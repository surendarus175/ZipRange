package com.suren.test;
/**
 * @author surendar
 */

import com.suren.main.ZipRange;
import com.suren.model.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ZipRangeTest {

    private ArrayList<Range> expectedResult;

    @Before
    public void setUp() {
        this.expectedResult = new ArrayList<Range>();
    }

    @After
    public void tearDown() {
        this.expectedResult.clear();
        ZipRange.clear();
    }

    @Test
    public void ZipRangetestWithNumbers() {

        setUp();

        Range a = new Range(3, 5);
        Range b = new Range(10, 13);
        Range c = new Range(8, 11);
        Range d = new Range(15, 19);
        Range e = new Range(13, 16);

        ZipRange.addZipRange(a);
        ZipRange.addZipRange(b);
        ZipRange.addZipRange(c);
        ZipRange.addZipRange(d);
        ZipRange.addZipRange(e);

        //Test size
        assertEquals("failure - expected result size match", 2, ZipRange.size());

        //Test content
        ArrayList<Range> expectedResult = new ArrayList<Range>();
        expectedResult.add(a);

        Range f = new Range(8, 19);
        expectedResult.add(f);

        assertEquals("failure - expected result content match", expectedResult.toString(), ZipRange.getZipRanges().toString());
    }


    @Test
    public void ZipRangetestWithData1() {

        setUp();

        Range a = new Range(94133, 94133);
        Range b = new Range(94200, 94299);
        Range c = new Range(94600, 94699);

        ZipRange.addZipRange(a);
        ZipRange.addZipRange(b);
        ZipRange.addZipRange(c);

        assertEquals("failure - expected result size match", 3, ZipRange.size());

        Range e = new Range(94133, 94133);
        Range f = new Range(94200, 94299);
        Range g = new Range(94600, 94699);

        expectedResult.add(e);
        expectedResult.add(f);
        expectedResult.add(g);

        assertEquals("failure - expected result content match", expectedResult.toString(), ZipRange.getZipRanges().toString());
        tearDown();
    }

    @Test
    public void ZipRangetestWithData2() {

        setUp();

        Range a = new Range(94133, 94133);
        Range b = new Range(94200, 94299);
        Range c = new Range(94226, 94399);

        ZipRange.addZipRange(a);
        ZipRange.addZipRange(b);
        ZipRange.addZipRange(c);

        assertEquals("failure - expected result size match", 2, ZipRange.size());

        Range e = new Range(94133, 94133);
        Range f = new Range(94200, 94399);

        expectedResult.add(e);
        expectedResult.add(f);

        assertEquals("failure - expected result content match", expectedResult.toString(), ZipRange.getZipRanges().toString());
        tearDown();
    }

}
