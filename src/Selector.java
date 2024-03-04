import java.util.*;

class Selector {
    MovieRepository rep = new MovieRepository();

    public void printMovies(){
       if(rep.getMap().isEmpty()){
           System.out.println("The movies list is Empty.");
       }
       else{
           for(Map.Entry<Integer,String> entry : rep.getMap().entrySet()){
              System.out.println("ID: "+entry.getKey()+", Name: "+entry.getValue());
           }
       }
   }

   

   public String GenerateRandomMovie(){
       if(rep.isEmpty()){
           return "The movies list is Empty.";
       }
       int keyNumber=rep.getRange();
       Random random = new Random();

       int key=random.nextInt(keyNumber)+1;
       String movie=rep.getMovie(key);

       while(movie==null){
            key=random.nextInt(keyNumber)+1;
            movie=rep.getMovie(key);
       }

   
       return movie;

       }

       public void dataEntry(){
           Scanner input = new Scanner(System.in);

               System.out.println("Enter movie name: ");
               String movie = input.nextLine();
               System.out.println("Enter movie number: ");
               int ID = Integer.parseInt(input.nextLine());

               rep.addMovie(movie,ID);
           } 
           
   

       public void Mainfunc(){ // main fuction

           Scanner input = new Scanner(System.in);
               int movieNumber=0;
               int choice=0;
   
               while(true){
   
               System.out.println("Enter your choice : ");
               System.out.println("1) Insert a movie to the list ");
               System.out.println("2) Delete a movie from the list ");
               System.out.println("3) Randomly generate a movie ");
               System.out.println("4) Clear all the list ");
               System.out.println("5) Get movie with key ");
               System.out.println("6) print all movies ");
   
               choice=Integer.parseInt(input.nextLine());
   
   
               switch (choice) {
                   case 1:
                   // insert movie
                       dataEntry();
                       break;
                   case 2:
                   // delete movie
                       System.out.println("Enter movie key to delete it :");
                       movieNumber=Integer.parseInt(input.nextLine());
                       rep.deleteMovie(movieNumber);
                       break;
   
                   case 3:
                   // randomly generate a movie
                       System.out.println(GenerateRandomMovie()); 
                       break;
   
                   case 4:
                   // clear all the list
                       rep.clearMap();
                       break;
   
                   case 5:
                   // get movie
                       System.out.print("Please enter the number of the movie you want to add :");
                       movieNumber=Integer.parseInt(input.nextLine());
                       String movie=rep.getMovie(movieNumber);
                       if (movie != null) {
                           System.out.println("The movie is: " + movie);
                   }   else {
                           System.out.println("The movie with the given number was not found.");
                   }
                   
   
                   break;
   
                   case 6:
                   // display all movies in ascending order by name
                       printMovies();
                   break;
               
                   default:
                       System.out.println("Invalid choice, please try again!");
                       break;
               }
               }
           } 
       }