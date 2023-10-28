package com.example.hogwartz

class User {

    var name :String?=null
    var gender:String?=null
    var age:Int?=null
    var mobileno:String?=null
    var roomno:Int?=null
    var email:String?=null
    var uid:String?=null


    constructor(){}

    constructor(name: String?,gender:String?,age:Int?,mobileno:String?,roomno:Int?,email:String?,uid:String?){

        this.name=name
        this.gender=gender
        this.age=age
        this.mobileno=mobileno
        this.roomno=roomno
        this.email=email
        this.uid=uid

    }

}