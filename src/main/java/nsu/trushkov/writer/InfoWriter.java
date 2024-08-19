package nsu.trushkov.writer;

import nsu.trushkov.model.InfoForReport;


/**
 * Interface is for sending a report.
 * <p>
 * Classes that implement this interface must implement sending logic a report.
 */
public interface InfoWriter {

    /**
     * Method is for sending a report.
     * @param infoForReport this is object that contains answers to questions
     */
    void write(InfoForReport infoForReport);

}
