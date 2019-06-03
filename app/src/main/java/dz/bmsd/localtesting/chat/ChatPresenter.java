package dz.bmsd.localtesting.chat;

public class ChatPresenter implements ChatContract.Presenter {
    private ChatContract.View chatView;

    public ChatPresenter(ChatContract.View chatView) {
        this.chatView = chatView;
    }

    @Override
    public void sendMessage(String message) {

        if( message != null && !message.isEmpty()){
            chatView.addMessage(message);
        }
    }

    @Override
    public void messageInputTextChanged(String inputMessage) {
        if( inputMessage != null && !inputMessage.isEmpty()){
            chatView.enableSendButton();
        }else{
            chatView.disableSendButton();
        }
    }
}
