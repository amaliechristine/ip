public class RejseKort {


int balance;
boolean checkedIn;
int timeStamp;
int maxX;
int maxY;
int minX;
int minY;

public RejseKort() {
    this.balance = 100;
    this.checkedIn = false;
}

public void depositMoney(int dkk) {
    this.balance = balance + dkk;

    if (dkk<0) {
        System.out.println("Error: Cannot deposit negative amount");
    } else {
        System.out.println(dkk + " DKK deposited. New balance: " + balance + " DKK");
    }

}

public boolean isCheckedIn(int timeStamp) {
    return calculateTimeDifference(timeStamp)>=0 && calculateTimeDifference(timeStamp)<=120 && checkedIn==true;
}

public void checkIn(int x, int y, int timeStamp) {
    if (balance<100) {
        int moneyNeeded = 100 - balance;
        System.out.println("Not enough money in account to check in. Please deposit at least " + moneyNeeded + " DKK");
    } else {
        if (isCheckedIn(timeStamp)) {
            System.out.println("Continued journey (" + 
            calculateTimeDifference(timeStamp) + 
            " minutes since last check in)");
            checkedIn = true;
            setXYValues(x, y);
            this.timeStamp = timeStamp;
        } else {
            System.out.println("Checked in");
            checkedIn = true;
            this.timeStamp = timeStamp;
            maxX=x; minX=x; maxY=y; minY=y;
    }
    }
}

public void checkOut(int x, int y, int timeStamp) {
    setXYValues(x, y);
    int price = 12 + ((maxX - minX + maxY - minY)*3);
    if (price>50) { price = 50;}
    if (price<12) { price=12;}
    balance -= price;

    if (checkedIn) {
        System.out.println("Checked out! " + 
        calculateTimeDifference(timeStamp) + 
        " minutes since last check in. Price is " + 
        price + " DKK, remaining balance is " + 
        balance + " DKK");
        checkedIn = false;
    } else {
        System.out.println("Error: Cannot check out; Not currently checked in");
    }
}

public void setXYValues(int x, int y) {
    if (x>maxX) { maxX = x; }
    if (x<minX) { minX = x; }
    if (y>maxY) { maxY = y; }
    if (y<minY) { minY = y; }
}

public int calculateTimeDifference(int timeStamp) {
    return timeStamp - this.timeStamp;
}

}