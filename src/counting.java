import java.text.NumberFormat;

public class counting {
 public void run()
 {
  double xorInput[][] =
  {
   {0.000,0.000,0.075,0.100},
   {0.0750,0.100,0.150,0.000},
   {0.150,0.000,0.225,-0.100},
   {0.225,-0.100,0.300,0.000},
   {0.300,0.000,0.375,0.100},
   {0.375,0.100,0.450,0.000},
   {0.450,0.000,0.525,-0.100},
   {0.525,-0.100,0.600,0.000}
   };

  double testInput[][] =
  {
		  {0.600,0.000,0.675,0.100}
   };

  
  double xorIdeal[][] =
  {{0.150,0.000},{0.225,-0.100},{0.300,0.000},{0.375,0.100},{0.450,0.000},{0.525,-0.100},{0.600,0.000},{0.675,0.100}};

  System.out.println("Learn:");

  Network network = new Network(4,5,2,0.7,0.9);

  NumberFormat percentFormat = NumberFormat.getPercentInstance();
  percentFormat.setMinimumFractionDigits(4);


  for (int i=0;i<50000;i++) {
   for (int j=0;j<xorInput.length;j++) {
    network.computeOutputs(xorInput[j]);
    network.calcError(xorIdeal[j]);
    network.learn();
   }
   System.out.println( "Trial #" + i + ",Error:" +
             percentFormat .format(network.getError(xorInput.length)) );
  }

  System.out.println("Recall:");

  for (int i=0;i<testInput.length;i++) {

   for (int j=0;j<testInput[0].length;j++) {
    System.out.print( testInput[i][j] +":" );
   }

   double out[] = network.computeOutputs(testInput[i]);
   System.out.println("="+out[0]+","+out[1]);
  }
 }
}