package lab1.footballclub;

import java.util.Objects;
/**
 * class "Position" with fields: positionName, trainer
 * @author User
 * @version 1.0
 */
public class Position {
    public String positionName;
    public Trainer trainer;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Position" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return positionName.equals(position.positionName) && trainer.equals(position.trainer);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(positionName, trainer);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Position"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Position{" +
                "positionName='" + positionName + '\'' +
                ", trainer=" + trainer +
                '}';
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Position"
     *  @return returns the string representation
     */

    public static class Builder {
        private Position position;

        public Builder(){ position = new Position(); }

        /**
         * Setter type designation
         *
         * @param positionName - name of position
         * @return returns current object
         */
        public Builder setPositionName(String positionName){
            position.positionName = positionName;
            return this;
        }

        /**
         * Setter type designation
         * @param trainer - trainer
         * @return returns current object
         */
        public Builder setTrainer(Trainer trainer){
            position.trainer = trainer;
            return this;
        }

        /**
         * Function of creating an object of class "Position"
         * @return returns new object of class 'Position"
         */
        public Position build(){
            return position;
        }
    }


}
