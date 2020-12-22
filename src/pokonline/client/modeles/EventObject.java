package pokonline.client.modeles;

public class EventObject {
    float TimeSinceTrigger = 0;
    float TriggerInterval;
    boolean FireOnce;
    boolean Fired;

    public EventObject(float triggerInterval, boolean fireOnce) {
       TriggerInterval = triggerInterval;
       FireOnce = fireOnce;
    }

    public void update(float delta) {
        TimeSinceTrigger += delta;
    }

    public boolean isReady() {
        if(FireOnce && Fired)
            return false;

        if(TimeSinceTrigger >= TriggerInterval) {
            if(FireOnce)
                Fired = true;
            else
                TimeSinceTrigger = 0;

            return true;
        }
        return false;
    }


}
