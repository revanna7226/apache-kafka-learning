export class Message {
    public topic: string;
    public key: string;
    public headers: string;
    public payload: string;

    constructor(topic: string, key: string, headers: string, payload: string) {
        this.topic = topic;
        this.key = key;
        this.headers = headers;
        this.payload = payload;
      }
}