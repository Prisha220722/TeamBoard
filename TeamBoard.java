import java.util.Scanner; //importing the scanner so we get input from user 

public class TeamBoard { //name of class
    
    public static void main(String[] args) { //start of Java program 
        Scanner inputScanner = new Scanner(System.in); //creating a scanner called inputScanner that allows us to read user types 
        String[] notices = new String[10]; //the noticeboard should be represented as an array of 10 strings; so notices[1],notices[2]...

        
        int numberOfNotices = 0; //keeping track of how many notices that are posted and start at 0 because there aren't notices when the program starts  
        int choice = 0; //stores the number user can choose from menu and start at 0 so the loop can start

        while (choice!= 9) { //keep showing the menu and accept choices as long as the user hasn't chosen 9 and when they do choose 9 the program will stop
            //displays menu options to the user 
            System.out.println("(1) Post new notice"); 
            System.out.println("(2) Print all notices");
            System.out.println("(3) Print all notices in reverse order"); 
            System.out.println("(4) Print number of notices posted so far"); 
            System.out.println("(5) Search for a captain's name and print all notices they have posted");
            System.out.println("(6) Print the total number of digits across all notices");
            System.out.println("(7) Perform a search of notices containing a given word (case sensitive)");  
            System.out.println("(8) Perform a search of notices containing a given word (case insensitive)"); 
            System.out.println("(9) End Program");  

            System.out.println("Enter your choice: "); //asks the user to enter their option and users should be able to choose their option 
            choice = inputScanner.nextInt();//reads the whole number the user put and puts it in choice 
            inputScanner.nextLine(); //clears the leftover enter key 

            if (choice == 1) { //only runs if they choose option 1 
                if (numberOfNotices == 10) { //If a captain tries to make a new notice when the noticeboard is full, display an error message and reject the new notice
                    System.out.println("The noticeboard is full."); 
                } else { //if there aren't 10 notices yet then we can allow the user to post one 
                    String captainName = inputScanner.nextLine(); //reads the captains name and stores it in captainName 
                    
                    System.out.print("Enter your notice: "); //asks the user for their choice 
                    String notice = inputScanner.nextLine(); //reads the notice and stores it in notice 
                    String fullNotice = captainName + "posts: " + notice; //combines the captains name. posts and notice into one string 
                    notices[numberOfNotices] = fullNotice; //puts the notice into the next position array 
                    numberOfNotices = numberOfNotices + 1; //increase the number of notices by 1
                    System.out.println(fullNotice); //print out the notice 
                }
            }
            if (choice == 2) { //print all notices 
                for (int i = 0; i < numberOfNotices; i++) { //goes through every notice in the array 
                //i+0 starts at position 0 
                //i<numberOfNotices keeps going while there are notices to print 
                //i++ moves to the next position 
                    System.out.println(notices[i]); //prints the current notice 
                }
            }
            if (choice == 3) { //prints notices in reverse order 
                for (int i = numberOfNotices - 1; i >= 0; i--) { //starts at last notice and moves backwards 
                    System.out.println(notices[i]); //prints the current notice 
                }
            }
            if (choice == 4) { //print the number of notices 
                System.out.println("Number of notices posted: " + numberOfNotices); 
            }
            if (choice == 5) { //search for notices that are posted by a captain 
                System.out.print("Enter captain's name: ");
                String searchName = inputScanner.nextLine(); //gets the captain's name to search for and stroes it in searchName

                for (int i = 0; i < numberOfNotices; i++) { //check every notice 
                    if (notices[i].toLowerCase().startsWith(searchName.toLowerCase())){ //.toLowerCase() makes everything lowercase so caps doesn't matter, .startsWith() checks whether the notice starts with that name 
                        System.out.println(notices[i]);
                    }
                }
            }
            if (choice == 6) { //counts all the digits in notice content 
                int digitCount = 0;  //starts at 0 and keeps track of number of digits
                for (int i = 0; i < numberOfNotices; i++){ //check each notice 
                    for (int j = 0; j < notices[i].length(); j++){ //this goes through each character in the notice 
                        if (Character.isDigit(notices[i].charAt(j))) { //charAt(j) gets the current character, Character.isDigit() checks whether the character is a number from 0 to 9 
                            digitCount = digitCount + 1; //increases the counter by 1 
                        }
                    }
                }

                System.out.println("Total number of digits: " + digitCount);
            }
            if (choice == 7) { //searchs for word with case sensitivity 
                System.out.print("Enter a word to search for: "); 
                String searchWord = inputScanner.nextLine(); //gets the word to search for and stores in searchWord 

                for (int i = 0; i < numberOfNotices; i++) { //loops through each notice and checks them 
                    if (notices[i].contains(searchWord)) { //checks whether the notice has the exact search word 
                        System.out.println(notices[i]); //prints matching notice 
                    }
                }
            }

            if (choice == 8) { //search for word ignoring case 
                System.out.print("Enter a word to search for: ");
                String searchWord = inputScanner.nextLine(); //gets the word to search for 

                for (int i = 0; i < numberOfNotices; i++) { //checks each notice 
                    if (notices[i].toLowerCase().contains(searchWord.toLowerCase())) { //makes both notice and search word lowercase before checking and checks if the notice contains the search word 
                        System.out.println(notices[i]);
                    }
                }
            }
        }

        }
    }

