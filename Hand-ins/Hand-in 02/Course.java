public class Course {

    private int enrolments;

    private String name;

    public Course(String name, int enrolments)
    {
        this.enrolments = enrolments;
        this.name = name;

    }

    public String getName()
    {
        return name;
    }

    public int getEnrolments()
    {
        return enrolments;
    }

    public String toString()
    {
        return "The name of the course is " + name + " and there are " + enrolments + " students enrolled in the course";
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEnrolments(int enrolments)
    {
        if ((enrolments >= 0) && (enrolments <= 300)) {
            this.enrolments = enrolments;
        } else if (enrolments < 0) {
            System.out.println("The number of enrolled students cannot be negative!");
        } else {
            System.out.println("The number of enrolled students cannot be greater than 300!");
        }
    }

}