package digital.paisley.tmt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.exception.ExceptionHandler;

@Slf4j
class RepeatExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(RepeatContext rc, Throwable throwable) {
        if (throwable instanceof FlatFileParseException) {
            FlatFileParseException fe = (FlatFileParseException) throwable;
            log.error("\nParse exception at line# " + fe.getLineNumber() + " input is: \n---\n" + fe.getInput() + "\n---");
        } else
            log.error("exception in parsing: ", throwable);
    }
}