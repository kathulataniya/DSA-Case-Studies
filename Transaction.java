import java.util.Scanner;

class Transaction {
    int transactionId;
    double amount;

    Transaction(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
}

public class Main {

    static void merge(Transaction arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Transaction[] L = new Transaction[n1];
        Transaction[] R = new Transaction[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (L[i].amount <= R[j].amount) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(Transaction arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void display(Transaction arr[]) {

        System.out.println("\nSorted Transaction Report");

        System.out.println("--------------------------------");
        System.out.println("Transaction ID\tAmount");
        System.out.println("--------------------------------");

        for (Transaction t : arr) {
            System.out.println(t.transactionId + "\t\t" + t.amount);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" FINPULSE BANKING ANALYTICS SYSTEM ");
        System.out.println("======================================");

        System.out.print("Enter Number of Transactions: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of transactions!");
            return;
        }

        Transaction[] transactions = new Transaction[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nTransaction " + (i + 1));

            System.out.print("Enter Transaction ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Transaction Amount: ");
            double amount = sc.nextDouble();

            transactions[i] = new Transaction(id, amount);
        }

        mergeSort(transactions, 0, n - 1);

        display(transactions);

        System.out.println("\nAnalysis Completed Successfully.");

        sc.close();
    }
}