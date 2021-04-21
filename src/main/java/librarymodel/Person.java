package librarymodel;

public class Person {
    private final String name;
    private final String position;
    private int priorityLevel;


    public Person(String name, String position) {
        this.name= name;
        this.position = position;
        setPriorityLevel();



    }

    public void setPriorityLevel(){
        if(this.position.equalsIgnoreCase("Teacher")){
            this.priorityLevel = 1;
        }else if(this.position.equalsIgnoreCase("Senior Student")){
            this.priorityLevel = 2;
        }else if(this.position.equalsIgnoreCase("Junior Student")){
            this.priorityLevel = 3;
        }else{
            this.priorityLevel = -1;
        }
    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }
}
