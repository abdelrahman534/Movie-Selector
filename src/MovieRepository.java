import java.util.*;

class MovieRepository{ // the database of movies
    private Map<Integer,String> map = new HashMap<>();
    int range=-1;

    public Map<Integer,String> getMap(){
        return this.map;
    }

    public int getSize(){
        return map.size();
    }

    public void addMovie(String movie,int ID){

        Scanner input = new Scanner(System.in);
            
            if(map.containsKey(ID)){
                System.out.println("This number is already in use.");
            }
            else{
                map.put(ID, movie);
                if(ID>range){
                    range=ID;
                }
                
            } 
            
    }

    public void deleteMovie(int key){
        if (map.containsKey(key)){
            map.remove(key);

            if(key==range){
                updateRange();
            }
            
        }
    }

    private void updateRange(){
        if(!map.isEmpty()){
            int maxKey=Collections.max(map.keySet());
            range=maxKey;
        }
        else{
            range=-1;  // no movies are left so you reset range
        }
    }

    public String getMovie(int key) {
        if(map.containsKey(key)){

            return map.get(key);
        }
        
         return null;
        
    }

    public void clearMap(){
        map.clear();
        range=-1;  // no movies are left so you reset range
    }

    public Integer getRange(){
        return range;
    }

    public boolean isEmpty(){
        return map.isEmpty();
    
    }

}