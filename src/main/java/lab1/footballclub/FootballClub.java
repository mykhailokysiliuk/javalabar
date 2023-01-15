package lab1.footballclub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * class "FootballClub" with fields: footballClubName, footballers
 * @author User
 * @version 1.0
 */
public class FootballClub {
    public String footballClubName;
    public List<Footballer> footballers = new ArrayList<>();

    public String getFootballClubName() {
        return footballClubName;
    }

    public void setFootballClubName(String footballClubName) {
        this.footballClubName = footballClubName;
    }

    public List<Footballer> getFootballers() {
        return footballers;
    }

    public void setFootballers(List<Footballer> footballers) {
        this.footballers = footballers;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "FootballClub" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub that)) return false;
        return footballClubName.equals(that.footballClubName) && Objects.equals(footballers, that.footballers);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(footballClubName, footballers);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "FootballClub"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "FootballClub{" +
                "footballClubName='" + footballClubName + '\'' +
                ", footballers=" + footballers +
                '}';
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "FootballClub"
     *  @return returns the string representation
     */

    public static class Builder {
        private FootballClub footballClub;

        public Builder(){ footballClub = new FootballClub(); }

        /**
         * Setter type designation
         *
         * @param footballClubName - name of the football club
         * @return returns current object
         */
        public Builder setFootballClubName(String footballClubName){
            footballClub.footballClubName = footballClubName;
            return this;
        }

        /**
         * Setter type designation
         * @param footballers - list of footballers
         * @return returns current object
         */
        public Builder setFootballers(List<Footballer> footballers){
            footballClub.footballers = footballers;
            return this;
        }

        /**
         * Function of creating an object of class "Footballer"
         * @return returns new object of class "Footballer"
         */
        public FootballClub build(){
            return footballClub;
        }
    }

}
