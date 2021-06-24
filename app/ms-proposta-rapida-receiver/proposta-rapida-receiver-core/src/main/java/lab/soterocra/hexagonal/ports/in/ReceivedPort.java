package lab.soterocra.hexagonal.ports.in;

import lab.soterocra.hexagonal.domain.model.Message;

public interface ReceivedPort {

    void hook(Message message) throws Exception;

}
