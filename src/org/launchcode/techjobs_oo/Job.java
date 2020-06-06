package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;

//    Below classes – Employer, Location, PositionType and CoreCompetency – each have value and id field;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {

        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;


}


//     WRITE FOR LOOP HERE TO CHECK FOR EMPTY FIELDS; IF EMPTY ASSIGN "DATA NOT AVAILABLE" AS VALUE


//    TODO: Add toString() method
    @Override
    public String toString() {

        if (this.name == null) {
            this.name = "Data not available";
        } else if ((this.getEmployer().getValue() == null) || (this.getEmployer().getValue().equals(""))) {
            setEmployer(new Employer ("Data not available"));
        } else if ((this.getLocation().getValue() == null) || (this.getLocation().getValue().equals(""))) {
            setLocation(new Location ("Data not available"));
        } else if ((this.getPositionType().getValue() == null) || (this.getPositionType().getValue().equals(""))) {
            setPositionType(new PositionType ("Data not available"));
        } else if ((this.getCoreCompetency().getValue() == null) || (this.getCoreCompetency().getValue().equals(""))) {
            setCoreCompetency(new CoreCompetency ("Data not available"));
        }



        return "\n" + "ID: " + getId() + "\n" + "Name: " + getName() + "\n" + "Employer: " + getEmployer() + "\n" + "Location: " + getLocation() + "\n" + "Position Type: " + getPositionType() + "\n" + "Core Competency: " + getCoreCompetency() + "\n" + "\n";
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job that = (Job) o;
        return id == that.id;
    }




    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
