package basic_class;

import java.util.ArrayList;

import basic_class.AlarmReminder;

/**
 * Created by wangjksjtu on 2016/11/26.
 */

public class AlarmReminderManager {
    private ArrayList<AlarmReminder> alarmReminders;
    private ArrayList<Integer> idlist;

    public boolean add(AlarmReminder alarmReminder)  {
        if (idlist.contains(alarmReminder.getId())) {
            alarmReminders.add(alarmReminder);
            return true;
        }
        else return false;
    }

    public boolean delete(AlarmReminder alarmReminder)  {
        if (idlist.contains(alarmReminder.getId())) {
            alarmReminder.stopRemind();
            alarmReminders.remove(search(alarmReminder));
            return true;
        }
        else return false;
    }

    private int search(AlarmReminder alarmReminder) {
        for (int i = 0; i < alarmReminders.size(); ++i) {
            if (alarmReminders.get(i).equals(alarmReminder))
                return i;
        }
        return -1;
    }
}
