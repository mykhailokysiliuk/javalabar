package lab1.footballclub;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * class "Footballer" with fields: firstname, lastname, dateOfBirth, physicalCondition, position, goalsNumber
 * @author User
 * @version 1.0
 */
public class Footballer implements Comparable<Footballer>{
    @Override
    public int compareTo(Footballer footballer) {
        return 0;
    }
    public enum PhysicalCondition { injured, healthy}
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Firstname must consists only from letter and first letter must be UpperCase")
    public String firstname;
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Last name must consists only from letter and first letter must be UpperCase")
    public String lastname;
    @PastOrPresent(message = "Date must be in the past or in the present")
    public LocalDate dateOfBirth;
    public PhysicalCondition physicalCondition;
    public Position position;
    public int goalsNumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PhysicalCondition getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(PhysicalCondition physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getGoalsNumber() {
        return goalsNumber;
    }

    public void setGoalsNumber(int goalsNumber) {
        this.goalsNumber = goalsNumber;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Footballer" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Footballer that)) return false;
        return goalsNumber == that.goalsNumber && firstname.equals(that.firstname) && lastname.equals(that.lastname) && dateOfBirth.equals(that.dateOfBirth) && physicalCondition == that.physicalCondition && position.equals(that.position);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, dateOfBirth, physicalCondition, position, goalsNumber);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Footballer"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Footballer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", physicalCondition=" + physicalCondition +
                ", position=" + position +
                ", goalsNumber=" + goalsNumber +
                '}';
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Footballer"
     *  @return returns the string representation
     */

    public static class Builder {
        private Footballer footballer;

        public Builder(){ footballer = new Footballer(); }

        /**
         * Setter type designation
         *
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            footballer.firstname = firstname;
            return this;
        }

        /**
         * Setter type designation
         * @param lastname - surname
         * @return returns current object
         */
        public Builder setLastname(String lastname){
            footballer.lastname = lastname;
            return this;
        }

        /**
         * Setter type designation
         * @param dateOfBirth - date of birth
         * @return returns current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            footballer.dateOfBirth = dateOfBirth;
            return this;
        }
        /**
         * Setter type designation
         * @param physicalCondition - health of the player
         * @return returns current object
         */
        public Builder setPhysicalCondition(PhysicalCondition physicalCondition){
            footballer.physicalCondition = physicalCondition;
            return this;
        }
        /**
         * Setter type designation
         * @param position - position
         * @return returns current object
         */
        public Builder setPosition(Position position){
            footballer.position = position;
            return this;
        }
        /**
         * Setter type designation
         * @param goalsNumber - number of scored goals
         * @return returns current object
         */
        public Builder setGoalsNumber(int goalsNumber){
            footballer.goalsNumber = goalsNumber;
            return this;
        }

        /**
         * Function of creating an object of class "Footballer"
         * @return returns new object of class "Footballer"
         */
        public Footballer build(){
            validate(footballer);
            return footballer;
        }
    }
    private static void validate(Footballer footballer) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Footballer>> check = validator.validate(footballer);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Footballer> element : check){
            sb.append("Error value "+element.getInvalidValue() + " because " + element.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void main(String args[]) {
        try{
            Footballer footballer = new Footballer.Builder()
                    .setFirstname("anto2")
                    .setLastname("griezmann")
                    .setDateOfBirth(LocalDate.of(2034, 1, 9))
                    .build();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

}
