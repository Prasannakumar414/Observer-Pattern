import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Observable {
    private HashMap<String,List<Observer>> observers;
    public void registerObserver(Observer observer,String topic) {
        List<Observer> observersList = observers.get(topic);
        if (observer!=null && topic!=null) {
            // if a new topic(channel is created) 
            if (observersList == null) {
                observersList = new ArrayList<Observer>();
                observersList.add(observer);
                observers.put(topic,observersList);
            } else {
                if(observersList.contains(observer)) {
                    System.out.println("Cannot register since the observer is already registered for this topic");
                } else {
                    observersList.add(observer);
                }
            }
        } else {
            System.out.println("Faced a error while registering!! observer or topic is null");
        }
    }
    public void removeObserver(Observer observer,String topic) {
        if (observer!=null && topic!=null) {
            List<Observer> observersList = observers.get(topic);
            if(observersList == null) {
                System.out.println("Unknown Topic !!");
            } else {
                observersList.remove(observer);
            }
        } else {
            System.out.println("Faced a error while removing!! observer or topic is null");
        }
    }
}