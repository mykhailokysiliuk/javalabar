package lab1.footballclub;

import java.time.LocalDate;
import java.util.Objects;
/**
 * class "Trainer" with fields: firstname, lastname, experience
 * @author User
 * @version 1.0
 */
public class Trainer {
    public String firstname;
    public String lastname;
    public LocalDate careerBeginning;

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

    public LocalDate getCareerBeginning() {
        return careerBeginning;
    }

    public void setCareerBeginning(LocalDate careerBeginning) {
        this.careerBeginning = careerBeginning;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Trainer" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer trainer)) return false;
        return firstname.equals(trainer.firstname) && lastname.equals(trainer.lastname) && careerBeginning.equals(trainer.careerBeginning);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, careerBeginning);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Trainer"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Trainer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", careerBeginning=" + careerBeginning +
                '}';
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Trainer"
     *  @return returns the string representation
     */

    public static class Builder {
        private Trainer trainer;

        public Builder(){ trainer = new Trainer(); }

        /**
         * Setter type designation
         *
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            trainer.firstname = firstname;
            return this;
        }

        /**
         * Setter type designation
         * @param lastname - surname
         * @return returns current object
         */
        public Builder setLastname(String lastname){
            trainer.lastname = lastname;
            return this;
        }

        /**
         * Setter type designation
         * @param careerBeginning - the beginning of a career as a trainer
         * @return returns current object
         */
        public Builder setCareerBeginning(LocalDate careerBeginning){
            trainer.careerBeginning = careerBeginning;
            return this;
        }

        /**
         * Function of creating an object of class "Trainer"
         * @return returns new object of class "Trainer"
         */
        public Trainer build(){
            return trainer;
        }
    }
}
