package com.vipin.algorithm.array;

public class ReferenceEnumCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Status s1 = Status.IS_APPROVED;
		Status s2 = Status.IS_APPROVED;
		if(s1==s2) {
			System.out.println(true);
		}
		if(s1==s2.IS_DENIED) {
			System.out.println(true);
		}
		if(s1==s2.IS_CLOSE) {
			System.out.println(true);
		}
		System.out.println(Status.IS_APPROVED);
		System.out.println(Status.IS_APPROVED);

	}

}

enum Status {
	IS_CLOSE(true),
    IS_APPROVED(true),
    IS_DENIED(true),
    IS_EXPIRED(true);

    private final boolean value;

    // Constructor
    Status(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}