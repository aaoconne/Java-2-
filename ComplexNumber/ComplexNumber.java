public class ComplexNumber{ //creating a class named complex number 
	private float real; //in each of these variables, I am creating two private floats that are named
	private float img; // real and img for the imaginary part
	
	public ComplexNumber(float real, float img) { // setting up a constructor that will initialize 
		this.real = real; //fields of the class written above
		this.img = img;  
	}

	public float getReal() {
		return this.real;
	} 

	public float getImg() {
		return this.img;
	}

	public ComplexNumber add(ComplexNumber otherNumber){ //I create a method called add that takes in otherNumber that is of type ComplexNumer
		ComplexNumber newComplex; //a new instance of ComplexNumber
		float newReal = real + otherNumber.getReal(); //I create a new instance of my variable real and add it to otherNumber
		float newImg = img + otherNumber.getImg(); //I do the same as above only I switch the variables so that img can be added together. 
		newComplex = new ComplexNumber(newReal, newImg); //a new instance of ComplexNumber that takes in the paramaters which are newReal and newImg
		return newComplex; //return the new instance
	}

	public ComplexNumber subtract(ComplexNumber otherNumber){ //same as the add method only this one applies the rules of subtraction
		ComplexNumber newComplex;
		float newReal = real - otherNumber.getReal();
		float newImg = img - otherNumber.getImg();
		newComplex = new ComplexNumber(newReal, newImg);
		return newComplex; 
	}

	public ComplexNumber multiply(ComplexNumber otherNumber){ //same as the previous methods but this works with the multiplication of complex numbers 
		 ComplexNumber newComplex;
		 //creation of a variable called difference that is of type float
		 float sum; //creation of a vairable called sum that is of type float
		 float newReal = real * otherNumber.getReal(); //works the same as before but now we are multiplying 
		 float newImg = img * otherNumber.getImg();
		 float newA = img * otherNumber.getReal(); //I create a new variable called A that will hold the values of img multiplied by Real 
		 float newB = real * otherNumber.getImg(); //creation of a new variable called B that will hold the values of real multiplied by Img
		 float difference = newReal - newImg; // because we are multiplying complex numbers, we have to subtract the new instance of Real from the new instance of Img 
		 sum = newA + newB; //I set the sum to equal the addition of newA and newB
		 newComplex = new ComplexNumber(difference, sum); //a new instance of ComplexNumber that takes in the paramaters which are the difference and the sum variables
		 return newComplex; 
	}
	public ComplexNumber divide(ComplexNumber otherNumber){ //same as before but now we move onto division 
		 ComplexNumber newComplex;
		 float sum;
		 float divide1; //because we are now working with division of complex numbers, with both divide1 and divide2, i create two variables that are also of type float
		 float divide2;
		 float abSquared; //division of complex numbers require we square the denominators so this is a varibale abSquared of type float
		 float newReal = real * otherNumber.getReal();
		 float newImg = img * otherNumber.getImg();
		 float newA = img * otherNumber.getReal();
		 float newB = real * otherNumber.getImg();
		 sum = newReal + newImg;
		 float difference = newReal - newImg;
		 abSquared = (float) (Math.pow((double)otherNumber.getReal(), 2) + Math.pow((double)otherNumber.getImg(), 2)); //I have to call Math.pow since im squaring these variables after they are added together 
		 divide1 = sum / abSquared; //the sum vairbale is divided by the abSquared variable and is set to divide1
		 divide2 = difference / abSquared; //same principle as the line before but this time we are dividing the difference by abSquared
		 newComplex = new ComplexNumber(divide1, divide2); //new instance of ComplexNumber that takes in the paramaters divide1 and divide2 
		 return newComplex;
	}
	@Override 
	public boolean equals(Object obj){ //constructor of type boolean that takes in o which is obj type Object
		if(obj instanceof ComplexNumber){
			ComplexNumber other = (ComplexNumber) obj; 
			if((Math.abs(this.getReal() - other.getReal()) < 0.000001)
				&& (Math.abs(this.getImg()) - other.getImg()) < 0.000001)
				return true;
		}
		return false;
	}


	@Override
	public String toString() { //method that will return the variable "text" 
		//here I use the to string method to convert the real and img to being bound together
		return Float.toString(this.real) + "+" + Float.toString(this.img);

	}
}