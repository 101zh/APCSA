package Unit10;

// Have to get rid of package statement

import java.util.ArrayList;

public class AnagramList {
    private final ArrayList<String> anagrams;
    private int wordLen;

    public AnagramList(String word) {
        anagrams = new ArrayList<String>();
        wordLen = word.length();
        // Add appropriate call to completeAnagrams here
        completeAnagrams("", word);
        sortAnagrams();
    }

    private void completeAnagrams(String start, String end) {
        if (end.length() <= 1) {
            anagrams.add(start + end);
        } else {
            for (int i = 0; i < end.length(); i++) {
                if (end.substring(0, i).indexOf(end.substring(i, i + 1)) < 0)
                    completeAnagrams(start + end.substring(i, i + 1), end.substring(0, i) + end.substring(i + 1));
            }
        }
    }

    private void sortAnagrams() {
        if (anagrams.size() < 7) {
            insertionSort();
        } else {
            ArrayList<String> extra = (ArrayList<String>) anagrams.clone();
            mergeSort(extra, 0, extra.size());
        }
    }

    private void insertionSort() {
        insertionSort(0, anagrams.size());
    }

    private void insertionSort(int from, int to) {
        for (int i = from + 1; i < to; i++) {
            String cur = anagrams.get(i);
            int j = i;
            while (j > 0 && cur.compareTo(anagrams.get(j - 1)) < 0) {
                anagrams.set(j, anagrams.get(j - 1));
                j--;
            }

            anagrams.set(j, cur);
        }
    }

    private void shuffle() {
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * anagrams.size());
            int index1 = (int) (Math.random() * anagrams.size());
            String temp = anagrams.get(index);
            anagrams.set(index, anagrams.get(index1));
            anagrams.set(index1, temp);
        }
    }

    private void mergeSort(ArrayList<String> aux, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            if (hi - lo < 7) {
                insertionSort(lo - 1, hi);
                merge(aux, lo, mid, hi);
            } else {

                mergeSort(aux, lo, mid);
                mergeSort(aux, mid + 1, hi);
            }

        }
    }

    private void merge(ArrayList<String> aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid;
        int k = 0;

        while (i < mid && j < anagrams.size()) {
            if (anagrams.get(i).compareTo(anagrams.get(j)) < 0) {
                aux.set(k, anagrams.get(i));
                i++;
                k++;
            } else {
                aux.set(k, anagrams.get(j));
                j++;
                k++;
            }
        }

        while (i < mid) {
            aux.set(k, anagrams.get(i));
            i++;
            k++;
        }

        while (j < anagrams.size()) {
            aux.set(k, anagrams.get(j));
            j++;
            k++;
        }
    }

    public int searchAnagrams(String target) {
        sortAnagrams();

        int start = 0;
        int end = anagrams.size();
        int mid = (start + end) / 2;
        while (start != end) {
            String midString = anagrams.get(mid);
            if (target.compareTo(midString) < 0) {
                end = mid - 1;
            } else if (target.compareTo(midString) > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }

        if ((mid >= 0 && mid < anagrams.size()) && target.equals(anagrams.get(mid)))
            return mid;
        else
            return -1;
    }

    // Used to get list of anagrams externally, do not remove
    public ArrayList<String> getAnagrams() {
        return anagrams;
    }

    @Override
    public String toString() {
        return anagrams.toString();
    }

    public static void main(String[] args) {
        AnagramList anagramList = new AnagramList("abcd");

        anagramList.shuffle();
        ;
        anagramList.sortAnagrams();

        System.out.println(anagramList);
    }
}
