public class AnimalDeck{
  
  String [] animals;
  int n;

  public AnimalDeck(){
    this.animals = new String []{"eagle", "monkey", "bird", "donkey", "ant", "camell", "fish", "bat", "cat", "chicken", "dolphin", "fox", "hen", "lion", "ostrich"};
    this.n = animals.length;
  }

  public int animalsLeft(){
    return this.n;
  }


  public String takeTheFirst(){
      String first = animals[0];
      for(int i=0; i<animals.length-1; i++){
        animals[i] = animals[i+1];
      }

      animals[animals.length-1] = null;
      n--;
      return first;
  }

}