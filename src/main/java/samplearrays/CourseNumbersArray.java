package samplearrays;



public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int c = registeredCourses.length;
        int[] updatedCourses = new int[c+1];
        System.arraycopy(registeredCourses, 0, updatedCourses, 0, c);
        int newCourse = 2006;
        updatedCourses[c] = newCourse;
        for(int i = 0; i< c+1; i++){
            System.out.print(updatedCourses[i] + ", ");
        }
        int specificNumber = 2080;
        for(int i = 0; i< c + 1; i++){
            if(updatedCourses[i] == specificNumber){
                System.out.println("\n" + specificNumber + " found");
            }

        }

    }
}
