package az.coders.enums;

import az.coders.exceptions.StateDoesNotEligible;

import java.util.Arrays;

public enum StateEnum {
    ONLINE(1),OFFLINE(0);

     private final   int stateCode;
    StateEnum(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public static StateEnum findByCode(int StateCode) {
        for (StateEnum stateCode1:StateEnum.values()
             ) {
            if (stateCode1.getStateCode() == StateCode){
                return stateCode1;
            }
        }
        throw new StateDoesNotEligible();
    }
}
