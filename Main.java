import java.util.Scanner;

class SubjectandMarks {
  private String sub;
  private int internalmarks;
  private int externalmarks;
  private double credit;
  private int maxMarks;

  public void setMaxMarks(int maxMarks){
    this.maxMarks=maxMarks;
  }
  public int getMaxMarks(){
    return maxMarks;
  }


  public void setSub(String sub){
      this .sub=sub;

  }

  public void setInternalMarks(int internalmarks){
      this.internalmarks=internalmarks;
  }
  public void setExternalMarks(int externalmarks){
      this.externalmarks=externalmarks;
  }
  public void  setCredit(double credit ){
      this.credit=credit;
  }
  public double getCredit(){
      return credit;
  }

  public String getSub(){
      return sub;
  }
  public int getTotalMarkobtained(){
      return internalmarks+externalmarks;
  }
  public int getInternalMarks(){
      return internalmarks;

  }
  public int getExternalMarks(){
      return externalmarks;
  }
  public double getCreditSCORE(int totalmarks , double newcredit , int marksobtained){
    double gp;
    double tenPercent=0.1*totalmarks;
    if(marksobtained>(totalmarks-tenPercent)){
        gp=10;
    }
    else if(marksobtained>(totalmarks-2*tenPercent)){
        gp=9;
    }
    else if(marksobtained>(totalmarks-3*tenPercent)){
        gp=8;
    }
    else if(marksobtained>(totalmarks-4*tenPercent)){
        gp=7;
    }
    else if(marksobtained>(totalmarks-5*tenPercent)){
        gp=6;
    }
    else if(marksobtained>(totalmarks-6*tenPercent)){
        gp=5;
    }
    else if(marksobtained>(totalmarks-7*tenPercent)){
        gp=4;
    }
    else{
        gp=0;
    }
    return gp*newcredit;

    



  }
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Std objStd= new Std();
        System.out.println("Enter number of the subjects ");
        objStd.setNoOfSubjects(scanner.nextInt());
        System.out.println("The sgpa is : "+objStd.returnsgpa());
        
    }
}

 class Std{
Scanner scanner= new Scanner(System.in);
private int noOfSubjects;

 public void setNoOfSubjects(int noOfSubjects){
   this.noOfSubjects=noOfSubjects;
 }
 public double returnsgpa(){
   SubjectandMarks subjectandMarks[]= new SubjectandMarks[noOfSubjects];
   double creditSum=0;
   double gpintocredit=0;
   for( int i=0 ;i< noOfSubjects;i++){
      subjectandMarks[i]= new SubjectandMarks();
      System.out.println("Enter the Subject Name  :");
      subjectandMarks[i].setSub(scanner.nextLine());
      scanner.nextLine();
      System.out.println("Enter the credit of the subject according to curriculam ");
      subjectandMarks[i].setCredit(scanner.nextDouble());
      System.out.println("Enter internal Marks in same subject :"); 
      subjectandMarks[i].setInternalMarks(scanner.nextInt());
      System.out.println("Enter External Marks obtained in same subject :");
      subjectandMarks[i].setExternalMarks(scanner.nextInt());
      System.out.println("enter total  marks for the subject ");
      subjectandMarks[i].setMaxMarks(scanner.nextInt());

      creditSum+=subjectandMarks[i].getCredit();
      gpintocredit+=subjectandMarks[i].getCreditSCORE(subjectandMarks[i].getMaxMarks(),subjectandMarks[i].getCredit(),subjectandMarks[i].getTotalMarkobtained());


   }
   return gpintocredit/creditSum;
   



 }



 



}