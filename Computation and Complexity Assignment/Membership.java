import java.io.*;
import java.util.*;

public class Membership {
    private static Map<String, MemberInfo> membershipDatabase = new HashMap<>();
    private static String outputFileName;
    private static String inputFileName;
    private static boolean outputAllMembers = false;

    private static boolean containsDuplicates = false;

    public static void main(String[] args) {


        if (args.length < 6) { // Replace 6 with the number of required arguments
            System.err.println("Not enough arguments provided. Please provide the required arguments.");
            return;
        }

        // Parse command line arguments and collect values into a map
        Map<String, String> argMap = parseCommandLineArgs(args);
        if (argMap == null) { // Exit if parsing fails
            System.err.println("Failed to parse command line arguments.");
            return;
        }

        outputFileName = argMap.get("outputFile");
        inputFileName = argMap.get("inputFile");
        System.out.println(argMap.entrySet());
        System.out.println(Boolean.parseBoolean(argMap.get("outputAllMembers")));
        
        if((Boolean.parseBoolean(argMap.get("outputAllMembers")))){
            outputAllMembers = true;
        }      

        readInitialDataFile(); // Read initial data file

        // Retrieve individual arguments from the map
        String firstName = argMap.get("firstname");
        String lastName = argMap.get("lastname");
        String phone = argMap.get("phone");
        boolean livesInNewYork = Boolean.parseBoolean(argMap.get("NewYork"));

        // Create new member from the command line arguments
        System.out.println(membershipDatabase.containsKey(phone));
        if (membershipDatabase.containsKey(phone)) {
            containsDuplicates=true;
            System.out.println("Duplicate phone number for member: " + phone);
        } else {
            MemberInfo newMember = createMemberFromArgs(firstName, lastName, phone, livesInNewYork);
            membershipDatabase.put(phone, newMember);
        }

        printMemberInfo(); // Print member information to output file
    }

    private static MemberInfo createMemberFromArgs(String firstName, String lastName, String phone, boolean livesInNewYork) {
        return new MemberInfo(firstName, lastName, phone, livesInNewYork);
    }


    private static Map<String, String> parseCommandLineArgs(String[] args) {
        Map<String, String> argMap = new HashMap<>();
        for (String arg : args) {
            String[] parts = arg.split("=", 2);
            if (parts.length == 2) {
                String key = parts[0].substring(1); 
                String value = parts[1];
                argMap.put(key, value);
                System.out.println(key+" "+value);
            }
        }

        // Check for required arguments
        if (!argMap.containsKey("outputFile") || !argMap.containsKey("inputFile")) {
            return null;
        }

        return argMap;
    }


    // Task#3: Read initial data file this method is fine
    private static void readInitialDataFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String phone = parts[2].trim();
                boolean newYork = Boolean.parseBoolean(parts[3].trim());
                membershipDatabase.put(phone, new MemberInfo(firstName, lastName, phone, newYork));
            }
        } catch (IOException e) {
            System.err.println("Error reading initial data file: " + e.getMessage());
        }
    }

    // Task#7 and Task#8: Print member information to output file
    private static void printMemberInfo() {
        try (FileWriter writer = new FileWriter(outputFileName)) {
            if (containsDuplicates==true){
                writer.write("Error: Duplicate Phone Number");
            }
            if (outputAllMembers) {
                // Output information for all members
                for (MemberInfo member : membershipDatabase.values()) {
                    writer.write(member.toString());
                }
            } else if (containsDuplicates==false){
                // Output information for the most recently added member
                MemberInfo member = membershipDatabase.get(membershipDatabase.keySet().toArray(new String[0])[(membershipDatabase.size() - 1)]);
                System.out.println(membershipDatabase.entrySet());
                writer.write(member.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to output file: " + e);
        }
    }
}

