import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { PublishMessageComponent } from './publish-message/publish-message.component';


@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    PublishMessageComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
