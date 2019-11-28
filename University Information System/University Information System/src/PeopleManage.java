//Implemented by Sam, tested by Sam:
interface PeopleManage <AnyType> extends PublicProperty{
	void addNewPeople(PublicProperty peopleProperty);
	PublicProperty getPeopleProperty();
	
	void kickPeople(String name);
	void setIdentity(String identity);
	
}//end interface
