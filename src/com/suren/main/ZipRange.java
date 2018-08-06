package com.suren.main;
/**
 * @author surendar
 */

//To find out the valid Zip Ranges

import com.suren.model.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ZipRange {

    private static List<Range> zipRangeList = new ArrayList<Range>();

    public static void main(String[] args) {

        Range range1 = new Range(94133, 94133);
        Range range2 = new Range(94200, 94299);
        Range range3 = new Range(94226, 94399);

        ZipRange.addZipRange(range1);
        ZipRange.addZipRange(range2);
        ZipRange.addZipRange(range3);

        showRange();
    }

    public static void addZipRange(Range toAddZipRange) {

        if (zipRangeList.size() == 0)
            zipRangeList.add(toAddZipRange);

        else {
            ListIterator<Range> iterator = zipRangeList.listIterator();
            boolean addRange = true;

            while (true) {
                //Add new Zip Range, if the range overlaps with existing range, merge them
                if (!iterator.hasNext())
                    break;
                Range range = iterator.next();
                if (range.getLowerZipCode() > toAddZipRange.getLowerZipCode() || range.getUpperZipCode() < toAddZipRange.getUpperZipCode()) {
                    if (range.getLowerZipCode() > toAddZipRange.getUpperZipCode() || range.getUpperZipCode() < toAddZipRange.getLowerZipCode())
                        addRange = true;

                        //Zip Range overlaps, removes existing one and update toAddZipRange
                    else {
                        if (range.getLowerZipCode() < toAddZipRange.getLowerZipCode())
                            toAddZipRange.setLowerZipCode(range.getLowerZipCode());
                        if (range.getUpperZipCode() > toAddZipRange.getUpperZipCode())
                            toAddZipRange.setUpperZipCode(range.getUpperZipCode());
                        iterator.remove();
                        addRange = true;
                    }
                } else
                    addRange = false;
            }
            if (addRange)
                zipRangeList.add(toAddZipRange);
        }
    }

    public static void showRange() {
        if (zipRangeList.size() > 0)
            zipRangeList.stream().map(Range::toString).forEach(System.out::print);
    }

    public static int size() {
        return zipRangeList.size();
    }

    public static List<Range> getZipRanges() {
        return zipRangeList;
    }

    public static void clear() {
        zipRangeList.clear();
    }

}
