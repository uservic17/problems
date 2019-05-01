package meetup;

public class KthLargest {
    /*
    todo = went into design.. a little shaky there
    distributed computers.. each have a heap..
    now.. at the end of the heap.. you can clearly take all heaps and merge them into one heap.. by doing x.k log(k)
    where x is number of computers.. and k is the size of heap.
    total elements is x.k and heapify will always be logk because that is the size

    but what about if you want real time..
    - we could take a snapshot and do this xklogk
    but what if i want it real time
    use a push technique.. rather than pull
    but remember if you want k = 2
    and you have
           1            and 100
        2k   3k          499  500

        both the big elemnets are in one heap.. so if you push a change in the highest elemnet.. then you miss out something

        think about it more
        ok.. for a change in every heap / computer.. if the heap changes.. push notification to the central merged heap
        here we are assuming that most of the heaps are not changing.
     */
}
