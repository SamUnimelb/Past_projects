# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import pandas as pd
import mysql.connector as connector

config={'host':'127.0.0.1',#By default local host
        'user':'root',
        'password':'12345',
        'port':3306 ,#By default port 3306
        'database':'complaint',
        'charset':'utf8' #By default UTF-8
}

class Complaint:
    def __init__(self, comp_id, id_sub, weeknum, weekday):
        self.comp_id = comp_id
        self.id_sub = id_sub
        self.weeknum = weeknum
        self.weekday = weekday

"""
def addSubjects():
    query = 
        INSERT INTO subject VALUES ('S', 'Service');
        INSERT INTO subject VALUES ('P', 'Product');
        INSERT INTO subject VALUES ('K', 'Kasyme');
        INSERT INTO subject VALUES ('R', 'Raquel');
        INSERT INTO subject VALUES ('B', 'Basel');

    try:
        cnn = connector.connect(**config)
        cursor = cnn.cursor()
        print(query)
        cursor.execute(query)
        cnn.commit()
        cursor.close()
        cnn.close()        
    except connector.IntegrityError:    
        print("Error")
"""

def write_to_db(complaint):
    query = ("INSERT INTO complaint VALUES (%d, '%s', %d, %d);" % 
             (complaint.comp_id, complaint.id_sub, complaint.weeknum, complaint.weekday))

    try:
        cnn = connector.connect(**config)
        cursor = cnn.cursor()
        print(query)
        cursor.execute(query)
        cnn.commit()
        cursor.close()
        cnn.close()        
    except connector.IntegrityError:    
        print("Error")

if __name__ == '__main__':
    #addSubjects()
    pdFrame = pd.read_excel('complaint_data.xlsx')
    comp_id = 1
    
    for index, line in pdFrame.iterrows():    
        weekday = 0
        for thing in line:
            if not pd.isnull(thing) and type(thing) != int:
                comps = thing.split(', ')
                for comp in comps:
                    c = Complaint(comp_id, comp, line['Week'], weekday)
                    print(c.comp_id, c.id_sub, c.weeknum, c.weekday)
                    write_to_db(c)
                    comp_id += 1
            weekday += 1