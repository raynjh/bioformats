/*
 * #%L
 * OME SCIFIO package for reading and converting scientific file formats.
 * %%
 * Copyright (C) 2005 - 2013 Open Microscopy Environment:
 *   - Board of Regents of the University of Wisconsin-Madison
 *   - Glencoe Software, Inc.
 *   - University of Dundee
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */

package loci.formats.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loci.common.Location;

/**
 * Generates fake screen/plate/well structures. Maximum supported size is
 * a 384 well plate with multiple runs and fields. Methods defensively check
 * caller-supplied arguments and throw relevant exceptions where needed.
 * @author Blazej Pindelski, bpindelski at dundee.ac.uk
 * @since 5.0
 */
public class FakeGenerator {

    public static String PLATE = "Plate";

    private static final Logger LOGGER = LoggerFactory.getLogger(
            FakeGenerator.class);
    private Location directoryRoot;

    public FakeGenerator(String directoryRoot) {
        this.directoryRoot = new Location(directoryRoot);
        if (!this.directoryRoot.isDirectory()) {
            throw new IllegalArgumentException("File name instead of " +
                    "directory supplied.");
        }
    }

    public static void isValidRange(int arg, int min, int max) {
        if (arg < min || arg > max) {
            throw new IllegalArgumentException("Method argument value " +
                    "outside valid range.");
        }
    }

    /**
     * Creates a fake SPW file/directory structure. All arguments indicating
     * plate or well element count must be at least <code>1</code> and cannot be
     * <code>null</code>. The structure appears on the file system as:
     * <br/>
     * <pre>
     * Plate001
     * |_
     *   Run001
     *   |_
     *     WellA01
     *     |_
     *       Field001.fake
     *       Field002.fake
     *       ...
     *     WellA02
     *     |_
     *       ...
     *   Run002
     *   |_
     *     ...
     * Plate002
     * |_
     *   ...
     * </pre>
     * @param baseDir Directory, where structure will be generated.
     * @param plates Number of plates in a screen (max 255).
     * @param plateAcquisitions Number of plate acquisitions (runs) in a plate
     * (max 255).
     * @param rows Number of rows in a plate (max 16).
     * @param columns Number of columns in a plate (max 24).
     * @param fields Number of fields for a plate acquisition (max 255).
     * @throws IllegalArgumentException when any of the arguments fail
     * validation.
     * @throws NullPointerException when null specified as argument value.
     */
    public void generateScreen(int plates, int plateAcquisitions, int rows,
            int columns, int fields) {
        isValidRange(plates, 1, 255);
        isValidRange(plateAcquisitions, 1, 255);
        isValidRange(rows, 1, 255);
        isValidRange(columns, 1, 255);
        isValidRange(fields, 1, 255);
        // For each plate:
        for (int i = 0; i < plates; ++i) {
            // create plate acquisitions
        }
        // for each plate acquisition:
        //   create wells (rows * columns)
        //   create fields
        
    }

}
