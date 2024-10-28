package by.it_academy.jd2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data

@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @SequenceGenerator(name = "message_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "sending_time")
    private LocalDateTime sendingTime;

    @ManyToOne
    @JoinColumn(name = "from_user", foreignKey = @ForeignKey(name = "from_user_FK"))
    private UserEntity fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user", foreignKey = @ForeignKey(name = "to_user_FK"))
    private UserEntity toUser;

    @Column
    private String text;

    public static MessageEntity.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private MessageEntity entity = new MessageEntity();

        private Builder() {
        }

        public MessageEntity.Builder setSendingTime(LocalDateTime sendingTime) {
            this.entity.sendingTime = sendingTime;
            return this;
        }

        public MessageEntity.Builder setFromUser(UserEntity fromUser) {
            this.entity.fromUser = fromUser;
            return this;
        }

        public MessageEntity.Builder setToUser(UserEntity toUser) {
            this.entity.toUser = toUser;
            return this;
        }

        public MessageEntity.Builder setText(String text) {
            this.entity.text = text;
            return this;
        }

        public MessageEntity build() {
            return this.entity;
        }
    }
}
