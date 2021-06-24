package lab.soterocra.hexagonal.usecase;

import lab.soterocra.hexagonal.domain.model.Message;

public class MessageFactory {
    public static Message getSuccessMessage() {
        return new Message("829182", "12938109", "Essa é uma mensagem de testes", "telegram", null);
    }
}
