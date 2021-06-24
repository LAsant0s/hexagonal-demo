package lab.soterocra.hexagonal.usecase;

import lab.soterocra.hexagonal.domain.model.Message;
import lab.soterocra.hexagonal.domain.model.exception.InvalidMessageException;
import lab.soterocra.hexagonal.ports.out.PostMessagePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class SendMessageToSystemUseCaseTest {

    @InjectMocks
    private SendMessageToSystemUseCase sendMessageToSystemUseCase;
    @Mock
    private PostMessagePort postMessagePort;

    @Test
    void hookExecuteSuccessfulFlowWhenReceiveFilledMessage() throws Exception {
        Message message = MessageFactory.getSuccessMessage();
        sendMessageToSystemUseCase.hook(message);
        Mockito.verify(postMessagePort, Mockito.times(1)).sendMessage(message);
    }

    @Test
    void hook_aoReceberMensagemNulaLancaExcecao() {
        InvalidMessageException t = Assertions.assertThrows(InvalidMessageException.class, () -> sendMessageToSystemUseCase.hook(null));
        Assertions.assertEquals("Mensagem nula, processo inválido.", t.getMessage());
    }

}