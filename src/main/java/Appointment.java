import java.util.ArrayList;

public class Appointment {
//    private int startPoint;
//    private int finishPoint;
//    private ArrayList<String> namesList;
//
//    public Appointment(int day, int hours, int minutes, int duration, ArrayList<String> namesList) {
//        this.startPoint = (day - 1) * 24 * 60 + hours * 60 + minutes;
//        this.finishPoint = this.startPoint + duration;
//        this.namesList = namesList;
//    }
//
//    public boolean isMatch(Appointment appoint) {
//        if (appoint.startPoint > this.startPoint && appoint.startPoint < this.finishPoint) {
//            return true;
//        } else if (appoint.finishPoint > this.startPoint && appoint.finishPoint < this.finishPoint) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public int getDay() {
//        return (int) ((this.startPoint / 60) / 24 + 1);
//    }
//
//    public int getHour() {
//        return (int) ((this.startPoint - (this.getDay() - 1) * 24 * 60) / 60);
//    }
//
//    public int getMinutes() {
//        return (int) (this.startPoint - (this.getDay() - 1) * 24 * 60 - this.getHour() * 60);
//    }
//
//    public int getDuration() {
//        return (int) (this.finishPoint - this.startPoint);
//    }
//
//    public static ArrayList<Object> validator(String[][] userInput) {
//        ArrayList<Object> apps = new ArrayList<Object>();
//        boolean flag = false;
//        for (int i = 0; i < userInput.length; i++) {
//            if (userInput[i][0].equals("APPOINT")) {
//                Appointment a = new Appointment(Integer.parseInt(userInput[i][1]),
//                        Integer.parseInt(userInput[i][2].split(":")[0]),
//                        Integer.parseInt(userInput[i][2].split(":")[1]),
//                        Integer.parseInt(userInput[i][3]),
//                        userInput[i][5]);
//                if (apps.size() == 0) {
//                    apps.add(a);
//                    flag = true;
//                } else {
//                    for (int j = 0; j < apps.size(); j++) {
//                        Appointment b = (Appointment) apps.get(j);
//                        if (a.getDay() == b.getDay()) {
//                            if (a.getHour() == b.getHour()) {
//                                if (a.getMinutes() == b.getMinutes()) {
//                                    flag = false;
//                                    break;
//                                } else if (a.getMinutes() < b.getMinutes()) {
//                                    if (a.getDuration() <= b.getMinutes() - a.getMinutes()) {
//                                        apps.add(j, a);
//                                        flag = true;
//                                        break;
//                                    } else {
//                                        flag = false;
//                                        break;
//                                    }
//                                } else {
//                                    if (a.getDuration() <= a.getMinutes() - b.getMinutes()) {
//                                        apps.add(j, a);
//                                        flag = true;
//                                        break;
//                                    } else {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
//                            } else if (a.getHour() < b.getHour()) {
//                                if (a.getDuration() <= (b.getHour() - a.getHour()) * 60 - a.getMinutes()) {
//                                    apps.add(j, a);
//                                    flag = true;
//                                    break;
//                                } else {
//                                    flag = false;
//                                    break;
//                                }
//                            } else {
//                                if (a.getDuration() <= (a.getHour() - b.getHour()) * 60 + a.getMinutes()) {
//                                    apps.add(j, a);
//                                    flag = true;
//                                    break;
//                                } else {
//                                    flag = false;
//                                    break;
//                                }
//                            }
//                        } else if (a.getDay() < b.getDay()) {
//                            if (a.getDuration() <= (b.getDay() - a.getDay()) * 24 * 60 - a.getHour() * 60 - a.getMinutes()) {
//                                apps.add(j, a);
//                                flag = true;
//                                break;
//                            } else {
//                                flag = false;
//                                break;
//                            }
//                        } else {
//                            if (a.getDuration() <= (a.getDay() - b.getDay()) * 24 * 60 + a.getHour() * 60 + a.getMinutes()) {
//                                apps.add(j, a);
//                                flag = true;
//                                break;
//                            } else {
//                                flag = false;
//                                break;
//                            }
//                        }
//                    }
//                    if (!flag) {
//                        apps.add(a);
//                    }
//                }
//            }
//        }
//        return apps;
//    }
}