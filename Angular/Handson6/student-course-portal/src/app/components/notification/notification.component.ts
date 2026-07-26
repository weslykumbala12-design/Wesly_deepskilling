import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification.service';

@Component({

  selector:'app-notification',

  standalone:true,

  templateUrl:'./notification.component.html',

  styleUrl:'./notification.component.css',

  providers:[NotificationService]

})
export class NotificationComponent{

  constructor(

    public notification:NotificationService

  ){}

}