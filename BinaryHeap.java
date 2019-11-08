public class BinaryHeap {
  // VARIABLES
  int size; // Size will track the # of items in the heap
  int[] arr; // Arr stores the data in int format

  // CONSTRUCTORS
  public BinaryHeap() {
    size = 0;
    arr = new int[10]; // starts at size of 10
  }

  //FUNCTIONS
  /*Adds an int (or Integer) instance to the priority queue*/
  public void add(int priority) {
    // If size is at the bounds of the array
    if(size == arr.length) {
      // Grow it
      grow_array();
    }
    // Set the last item to the input value
    arr[size++] = priority;
    // The new child is the item at the end
    int child = size - 1;
    // The parent is this value - mathematical rule
    int parent = (child - 1)/2;
    // While the child val > 0 and the child is less than the parent
    while(child > 0 &&  arr[child] < arr[parent]) {
      // Swap the two
      swap(arr, parent, child);
      // Set the child to the parent
      child = parent;
      // Set the parent to this val (same as above)
      parent = (child - 1)/2;
    }
  }

  /*Removes the highest priority item — i.e. the lowest
  number — from the priorityqueue. This function should
  throw an exception if the priority queue is empty*/
  int remove() {
    // Temp value is the 0th item, keep to return it later
    int temp = arr[0];
    // The item at 0 is set to the item at the end
    arr[0] = arr[size - 1];
    // The size is incremented down
    size--;
    // The recursive siftdown is performed on first item
    siftdown(0);
    // returns the temp stored val (item was at 0), the "root" of the heap
    return temp;
  }

  // Siftdown
  void siftdown(int parent) {
    // The functional inverse of the above equation.
    // NOTE that "child" records position, not actual contents
    int child = (parent * 2) + 1;
    // If the child pos is at or beyond size bounds
    if(child >= size) {
      // Just stop this branch of the siftdown
      return;
    }
    // If the array value next to child is less than the child value
    if(arr[child+1] < arr[child]) {
      // Increment the child indexer value (move forward in array)
      child++;
    }
    // If contents of parent index value are greater than child's
    if(arr[parent] > arr[child]) {
      // Swap them
      swap(arr, child, parent);
      // Sift down - recurse
      siftdown(child);
    }
  }

  // Grows array to twice its size
  private void grow_array() {
    // Create a new generic array of twice the size
    int[] new_a = new int[arr.length*2];
    // Copy the values over
		System.arraycopy(arr, 0, new_a, 0, arr.length);
    // Set the 'a' pointer to the 'new_a' pointer
    arr = new_a;
  }

  // Simple swap function
  void swap(int[] array, int A, int B) {
    int temp = array[A];
    array[A] = array[B];
    array[B] = temp;
  }


}
