package dz.bmsd.localtesting.chat;

public interface ChatContract {
    interface View {
        void addMessage(String message);

        void cleanMessageInput();

        void enableSendButton();

        void disableSendButton();
    }

    interface Presenter {
        void sendMessage(String message);

        void messageInputTextChanged(String inputMessage);

    }
}
