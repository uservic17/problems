package meetup;

//list of schedules given of different people
//Try to find 1hr meeting block for all
// find the number of maximum number of people who can attend this meeting - output: maximum number of people who can attend this meeting
//the times are not standard.. it can end and start at any time

//may be approach
/*
choose the first slot.. compress it according to the next guy.. and keep going until the slot becomes less than one hour.
Or
find the guy with the most time open
ok.. sort the ones with the least time open starting
then take that guy and see if all others are free

 */

/*
TODO - the solution is about jumping through all the start and end points
also follow up questions - give me the names of the people
                         - include at least this and this person
                         -
 */
import java.util.List;

public class MeetingScheduling {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int findMaxPeopleForOneHour(Interval[] input) {

        return 0;
    }



    //todo ONE sort the intervals with increasing amount of free time
    private void sort(List<List<Interval>> input) {


//        for ()
    }

    private void findOpenAmount(List<Interval> list) {
        int result = 0;
        int start = 9;
        int end = 5;
        for (Interval interval : list) {
//            if (interval.start)
        }





    }
    //todo TWO find the next open slot.


    //todo THREE sort an Interval  with decreasing



    //todo.. check if a person is open during this interval
    private boolean isOpen(List<Interval> list, Interval target) {
        for (Interval interval : list ) {
            if (interval.end >= target.start || interval.end >= target.end) {
                return false;
            } else if (interval.start >= target.start && interval.start <= target.end ) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Interval[][] input = { {new Interval(9,10)}


        };
    }
}
