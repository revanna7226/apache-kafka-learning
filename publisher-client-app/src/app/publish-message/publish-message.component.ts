import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PublishMessageService } from '../publish-message.service';
import { Message } from '../_models/message';

@Component({
  selector: 'app-publish-message',
  templateUrl: './publish-message.component.html',
  styleUrls: ['./publish-message.component.css']
})
export class PublishMessageComponent {

  errorMessage?: string;
  formValue?: Message;

  constructor(private fb: FormBuilder, private messageService: PublishMessageService) { }

  producerForm = this.fb.group({
    topic: ['', Validators.required],
    key: ['', Validators.required],
    headers: ['', Validators.required],
    payload: ['', Validators.required]
  });

  onSubmit() {
    if(this.producerForm.valid) {
      const value = this.producerForm.value;
      const messageData = new Message(value.topic!, value.key!, value.headers!, value.payload!);
      this.errorMessage = "Form submitted successfully!";
      this.messageService.publishMessage(messageData).subscribe(response => this.errorMessage = response.payload);
    } else {
      this.errorMessage = "Invalid Form Data!";
    }
  }

}
