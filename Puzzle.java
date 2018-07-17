import java.util.*;
import java.io.*;
class Graph{
	// public ArrayList<ArrayList<String>> AdjList; //adjacency list
	public String[][] AdjList;
	public String[] vertices;//mapping between vertex in integer and vertex in string
	public int lastIndVert;
	public HashMap<String,Integer> hm;//mapping between vertex in string and vertex in integer

	//*********PERMUTATIONS**************
    private void permute(String str, int l, int r){
        if (l == r){
            // System.out.println(str+"  "+lastIndVert);
            vertices[lastIndVert] = str;
			hm.put(vertices[lastIndVert],lastIndVert);
            lastIndVert++;
        }
        else{
            for (int i = l; i <= r; i++){
            	StringBuffer tmp = new StringBuffer(str);
            	char tmpChar = tmp.charAt(l);
            	tmp.replace(l,l+1,Character.toString(tmp.charAt(i)));
            	tmp.replace(i,i+1,Character.toString(tmpChar));
                // str = swap(str,l,i);
                
                permute(tmp.toString(), l+1, r);
                
                // str = swap(str,l,i);
            }
        }
    }
 
    // public String swap(String a, int i, int j)
    // {
    //     char temp;
    //     char[] charArray = a.toCharArray();
    //     temp = charArray[i] ;
    //     charArray[i] = charArray[j];
    //     charArray[j] = temp;
    //     return String.valueOf(charArray);
    // }

	public Graph() throws Exception{
		vertices = new String[362880];//assumed vertices are stored here
		lastIndVert = 0;
		hm = new HashMap<String,Integer>();
		permute("12345678G",0,8);
		// System.out.println(lastIndVert);	
		// Scanner sc = new Scanner(new File("permutations.txt"));
		// for(int i=0;i<362880;i++){
			// vertices[i] = sc.nextLine();
			// hm.put(vertices[i],i);
		// }
		// sc.close();
		AdjList = new String[362880][4];
		//create the adjacency list
		for(int i=0;i<362880;i++){
			String curr = vertices[i];
			// ArrayList<String> tmp = new ArrayList<String>();
			StringBuilder next1;
			String tmp2;
			if(curr.indexOf('G')==0){
				next1 = new StringBuilder(curr);
				next1.replace(0,1,Character.toString(curr.charAt(1)));
				next1.replace(1,2,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(0,1,Character.toString(curr.charAt(3)));
				next1.replace(3,4,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				AdjList[i][2] = "";
				AdjList[i][3] = "";
			}else if(curr.indexOf('G')==1){
				next1 = new StringBuilder(curr);
				next1.replace(1,2,Character.toString(curr.charAt(0)));
				next1.replace(0,1,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(1,2,Character.toString(curr.charAt(2)));
				next1.replace(2,3,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(1,2,Character.toString(curr.charAt(4)));
				next1.replace(4,5,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][2] = tmp2;
				AdjList[i][3] = "";
			} else if(curr.indexOf('G')==2){
				next1 = new StringBuilder(curr);
				next1.replace(2,3,Character.toString(curr.charAt(1)));
				next1.replace(1,2,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(2,3,Character.toString(curr.charAt(5)));
				next1.replace(5,6,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				AdjList[i][2] = "";
				AdjList[i][3] = "";
			}  else if(curr.indexOf('G')==3){
				next1 = new StringBuilder(curr);
				next1.replace(3,4,Character.toString(curr.charAt(0)));
				next1.replace(0,1,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(3,4,Character.toString(curr.charAt(4)));
				next1.replace(4,5,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(3,4,Character.toString(curr.charAt(6)));
				next1.replace(6,7,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][2] = tmp2;
				AdjList[i][3] = "";
			}   else if(curr.indexOf('G')==4){
				next1 = new StringBuilder(curr);
				next1.replace(4,5,Character.toString(curr.charAt(1)));
				next1.replace(1,2,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(4,5,Character.toString(curr.charAt(3)));
				next1.replace(3,4,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(4,5,Character.toString(curr.charAt(5)));
				next1.replace(5,6,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][2] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(4,5,Character.toString(curr.charAt(7)));
				next1.replace(7,8,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][3] = tmp2;
			} else if(curr.indexOf('G')==5){
				next1 = new StringBuilder(curr);
				next1.replace(5,6,Character.toString(curr.charAt(2)));
				next1.replace(2,3,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(5,6,Character.toString(curr.charAt(4)));
				next1.replace(4,5,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(5,6,Character.toString(curr.charAt(8)));
				next1.replace(8,9,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][2] = tmp2;
				AdjList[i][3] = "";
			} else if(curr.indexOf('G')==6){
				next1 = new StringBuilder(curr);
				next1.replace(6,7,Character.toString(curr.charAt(3)));
				next1.replace(3,4,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(6,7,Character.toString(curr.charAt(7)));
				next1.replace(7,8,"G");
				tmp2 =next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				AdjList[i][2] = "";
				AdjList[i][3] = "";
			} else if(curr.indexOf('G')==7){
				next1 = new StringBuilder(curr);
				next1.replace(7,8,Character.toString(curr.charAt(4)));
				next1.replace(4,5,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(7,8,Character.toString(curr.charAt(6)));
				next1.replace(6,7,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(7,8,Character.toString(curr.charAt(8)));
				next1.replace(8,9,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][2] = tmp2;
				AdjList[i][3] = "";
			} else if(curr.indexOf('G')==8){
				next1 = new StringBuilder(curr);
				next1.replace(8,9,Character.toString(curr.charAt(5)));
				next1.replace(5,6,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][0] = tmp2;
				next1 = new StringBuilder(curr);
				next1.replace(8,9,Character.toString(curr.charAt(7)));
				next1.replace(7,8,"G");
				tmp2 = next1.toString();
				// tmp.add(tmp2);
				AdjList[i][1] = tmp2;
				AdjList[i][2] = "";
				AdjList[i][3] = "";
			}
			 // AdjList.add(tmp);
		}	
	}
}

public class Puzzle{
	public static int returnCost(String[] cost, String first, String second){
		int indGinFirst = first.indexOf('G');
		int indInCostArray = Character.getNumericValue(second.charAt(indGinFirst)) - 1;
		return Integer.parseInt(cost[indInCostArray]);
	}
	public static boolean checkSolvable(String start, String end){
		int ct = 0;
		for(int i=0;i<8;i++){
			for(int j=i+1;j<9;j++){
				if(end.charAt(i)!='G' && end.charAt(j)!='G' && start.indexOf(end.charAt(i)) > start.indexOf(end.charAt(j)))
					ct++;
			}
		}
		// System.out.println(ct);
		if(ct%2==0) return true;
		else return false;

	}
	public static void main(String args[]) throws Exception{
		long initialTime = System.currentTimeMillis();
		
		FileOutputStream f = new FileOutputStream(args[1]);
		PrintStream p = new PrintStream(f);

		// String[] t = {"0","0","0","0","0","0","0","0"};
		// Graph G1 = new Graph(t);
		// for(int i=0;i<10;i++){
		// 	for(int j=0;j<G1.AdjList.get(i).size();j++)
		// 		System.out.println(G1.AdjList.get(i).get(j)[0]+" * "+G1.AdjList.get(i).get(j)[1]);
		// 	System.out.println("****");
		// }
		long time1 = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(args[0]));
		int t = Integer.parseInt(sc.nextLine());
		Graph G1 = new Graph();
		

		for(int tt = 0;tt<t;tt++){
			String[] startend = sc.nextLine().split(" ");
			String start    = startend[0];
			String end      = startend[1];
			String[] cost     = sc.nextLine().split(" ");
			// G1.setCost(cost);
			
			if(!checkSolvable(start,end)){
				try{
					
					p.println("-1 -1");
					p.println("");
				}catch(Exception e){
					;
				}
				// System.out.println("-1 -1");
				// System.out.println("");
				continue;
			}

			int[] dist1       = new int[362880]; //cumulative cost
			int[] dist2       = new int[362880]; //cumulative path length
			int[] previous    = new int[362880];//previous pointer
			int[] visited     = new int[362880]; //can be 1 or -1 to indicate visited or not
			
			int[] nonVisited  = new int[362881]; //USE MINHEAP These are the non cloud members
			int sizeHeap = 362880;
			int[] posInHeap   = new int[362880]; //the index of i node in the heap is posInHeap[i]

			for(int i=0;i<362880;i++){
				dist1[i]    = 2147483647;
				dist2[i]    = 2147483647;
				previous[i] = -1;
				visited[i]  = -1;
				nonVisited[i+1] = i;
				posInHeap[i]= i+1;
			}

			nonVisited[0] = -1;
			nonVisited[posInHeap[G1.hm.get(start)]] = 0; //swapping the source vertex
			posInHeap[0] = posInHeap[G1.hm.get(start)];
			nonVisited[1] = G1.hm.get(start);
			posInHeap[G1.hm.get(start)] = 1;

			dist1[G1.hm.get(start)]  = 0;
			dist2[G1.hm.get(start)]  = 0;
			//*************CODE TO HEAPIFY************
			//NO NEED
			//


			for(int i=0;i<362880;i++){
				// System.out.println(i);

				int minVertex= nonVisited[1];
				if(minVertex == G1.hm.get(end)) break;
				if (dist1[minVertex] == 2147483647) break; //case of unconnected graph
				// int minDist1 = 2147483647;
				// int minDist2 = 2147483647;
				// for(int j : nonVisited){
				// 	if(dist1[j] < minDist1){
				// 		minDist1 = dist1[j];
				// 		minDist2 = dist2[j];
				// 		minVertex= j;
				// 	}else if(dist1[j] == minDist1){
				// 		if(dist2[j] < minDist2){
				// 			minDist2 = dist2[j];
				// 			minVertex= j;
				// 		}
				// 	}
				// }
				//CODE FOR DELETE MIN using percolate down
				int toDelete  = nonVisited[sizeHeap]; 
				posInHeap[nonVisited[1]] = -1;
				nonVisited[1] = toDelete;
				sizeHeap--;
					
				int hole = 1;
					while(1==1){
						if(2*hole > sizeHeap){
							nonVisited[hole] = toDelete;
							posInHeap[toDelete] = hole;
							break;
						}else if(2*hole == sizeHeap){
							if((dist1[nonVisited[2*hole]] < dist1[toDelete])||((dist1[nonVisited[2*hole]] == dist1[toDelete]) && (dist2[nonVisited[2*hole]] <= dist2[toDelete]))){
								nonVisited[hole]   = nonVisited[2*hole];
								posInHeap[nonVisited[2*hole]] = hole;
								nonVisited[2*hole] = toDelete;
								posInHeap[toDelete]= 2*hole;
								break;
							}else{
								nonVisited[hole] = toDelete;
								posInHeap[toDelete] = hole;
								break;
							}
						}else{
							int smallChild;
							if((dist1[nonVisited[2*hole]] < dist1[nonVisited[2*hole+1]])||((dist1[nonVisited[2*hole]] == dist1[nonVisited[2*hole+1]]) && (dist2[nonVisited[2*hole]] <= dist2[nonVisited[2*hole+1]])))
								smallChild = 2*hole;
							else
								smallChild = 2*hole+1;
							if((dist1[nonVisited[smallChild]] < dist1[toDelete])||((dist1[nonVisited[smallChild]] == dist1[toDelete]) && (dist2[nonVisited[smallChild]] <= dist2[toDelete]))){
								nonVisited[hole] = nonVisited[smallChild];
								posInHeap[nonVisited[smallChild]] = hole;
								hole = smallChild;
							}else{
								nonVisited[hole] = toDelete;
								posInHeap[toDelete] = hole;
								break;
							}

						}
					}


				visited[minVertex] = 1;
				// nonVisited.remove(minVertex);
				String[] neighbours = G1.AdjList[minVertex];
				for(int j=0;j<neighbours.length;j++){
					if (neighbours[j] == "") break;
					if(visited[G1.hm.get(neighbours[j])]==1) continue;

					// int tmpDist1 = dist1[minVertex] + Integer.parseInt(neighbours.get(j)[1]);
					int tmpDist1 = dist1[minVertex] + returnCost(cost,G1.vertices[minVertex],neighbours[j]);
					int tmpDist2 = dist2[minVertex] + 1;
					if((tmpDist1 < dist1[G1.hm.get(neighbours[j])]) || ((tmpDist1 == dist1[G1.hm.get(neighbours[j])]) && (tmpDist2 < dist2[G1.hm.get(neighbours[j])]))){
						

						dist1[G1.hm.get(neighbours[j])]   = tmpDist1;
						dist2[G1.hm.get(neighbours[j])]   = tmpDist2;
						previous[G1.hm.get(neighbours[j])]= minVertex;

						//percolate this up
						int toMove = G1.hm.get(neighbours[j]);
						int toChange = posInHeap[toMove];

						while(toChange > 1 && ((dist1[toMove] < dist1[nonVisited[toChange/2]])||((dist1[toMove] == dist1[nonVisited[toChange]]) && (dist2[toMove] < dist2[nonVisited[toChange]])))) {
							nonVisited[toChange] = nonVisited[toChange/2];
							posInHeap[nonVisited[toChange/2]] = toChange;
							toChange = toChange/2;
						}
						nonVisited[toChange] = toMove;
						posInHeap[toMove] = toChange;
					



					}

				}

			}

			try{
				
					

				if(dist2[G1.hm.get(end)] == 2147483647){
					// System.out.println("-1 -1 ");
					// System.out.println("");
					p.println("-1 -1 ");
					p.println("");
				}
				else{
					if(dist2[G1.hm.get(end)] == 0){
						// System.out.println("0 0 ");
						// System.out.println("");
						p.println("0 0 ");
						p.println("");
					}
					else{
						p.println(dist2[G1.hm.get(end)]+" "+dist1[G1.hm.get(end)]);
						String first = end;
						String second;
						StringBuilder ans = new StringBuilder("");
						for(int i=0;i<dist2[G1.hm.get(end)];i++){
							second = G1.vertices[previous[G1.hm.get(first)]];
							int GinFirst = first.indexOf('G');
							int GinSecond = second.indexOf('G');
							String a = Character.toString(first.charAt(GinSecond));
							String b;
							if(GinSecond == GinFirst-1)
								b = "L";
							else if(GinSecond == GinFirst+1)
								b = "R";
							else if(GinSecond == GinFirst-3)
								b = "U";
							else
								b = "D";
							ans.append(" "+b+a);
							first = second;
						}
						ans.reverse();
						// System.out.println(ans);
						p.println(ans);
					}
				}
			}catch(Exception e){
				;
			}
			long time2 = System.currentTimeMillis();
			// System.out.println(time2 - time1);
			time1 = time2;




			//temporary code for backtrack
			// String toPrint = end;
			// while (1==1){
			// 	System.out.print(toPrint+" -> ");
			// 	int tmpp = previous[G1.hm.get(toPrint)];
			// 	if (tmpp == -1) break;
			// 	else toPrint = G1.vertices[tmpp];
			// }
			// System.out.println("");
			//Write the code for backtrack


		}


		
		long finalTime = System.currentTimeMillis();
			// System.out.println("TOTAL TIME IS: "+(-1*initialTime + finalTime));


   		
	}
}