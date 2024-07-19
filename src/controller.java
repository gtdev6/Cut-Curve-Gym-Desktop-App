import java.io.File;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.concurrent.Callable;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;


public class controller implements Initializable{

    @FXML
    Pane pane;
    @FXML
    Label songname;
    @FXML
    Label volume;
    @FXML
    Label currenttime;
    @FXML
    Label totallength;
    @FXML
    Slider lengthslider;
    @FXML
    Slider volumeslider;
    @FXML
    Button play,pause,forward,backward,next,previous,loop,loopall,stop,open;


    ArrayList<File> file=new ArrayList<File>();

    ArrayList<File> songList;
    int currentfile;
    int totalfiles;

    Image imgplay,imgpause,imgforward,imgbackword,imgnext,imgprevious,imgstop;
    ImageView img1,img2,img3,img4,img5,img6,img7;

    Boolean playing=false;
    Boolean pause1=false;

    String filepath;
    ArrayList<String> paths=new ArrayList<String>();
    public Media media;
    MediaPlayer mediaplayer;
    Boolean isloop=false,isloopall=false;


       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            imgplay=new Image(getClass().getResourceAsStream("/icons/Play.png"));
            imgpause=new Image(getClass().getResourceAsStream("/icons/pause.png"));
            imgforward=new Image(getClass().getResourceAsStream("/icons/forward.png"));
            imgbackword=new Image(getClass().getResourceAsStream("/icons/backward.png"));
            imgnext=new Image(getClass().getResourceAsStream("/icons/next.png"));
            imgprevious=new Image(getClass().getResourceAsStream("/icons/previous.png"));
            imgstop=new Image(getClass().getResourceAsStream("/icons/stop.png"));

            img1=new ImageView(imgplay);
            img2=new ImageView(imgpause);
            img3=new ImageView(imgforward);
            img4=new ImageView(imgbackword);
            img5=new ImageView(imgnext);
            img6=new ImageView(imgprevious);
            img7=new ImageView(imgstop);

            img1.setFitHeight(15);
            img2.setFitHeight(15);
            img3.setFitHeight(15);
            img4.setFitHeight(15);
            img5.setFitHeight(15);
            img6.setFitHeight(15);
            img7.setFitHeight(15);

            img1.setFitWidth(15);
            img2.setFitWidth(15);
            img3.setFitWidth(15);
            img4.setFitWidth(15);
            img5.setFitWidth(15);
            img6.setFitWidth(15);
            img7.setFitWidth(15);

            play.setGraphic(img1);
            // play.setBackground(null);
            pause.setGraphic(img2);
            stop.setGraphic(img7);
            forward.setGraphic(img3);
            backward.setGraphic(img4);
            next.setGraphic(img5);
            previous.setGraphic(img6);
            // loop.setGraphic(img1);
            // loopall.setGraphic(img1);
            volume.setText("50%");

            volumeslider.setValue(0.5);
           
        
    }

    
    public void play()
    {
        if(!playing)
        {
            mediaplayer.play();
            playing=true;
            songname.setText(file.get(currentfile).getName());
            play.setDisable(true);
            pause.setDisable(false);
        }
        else
        {
            media=new Media(file.get(currentfile).toURI().toString());
            mediaplayer=new MediaPlayer(media);
            mediaplayer.play();
            songname.setText(file.get(currentfile).getName());
            playing=true;
            play.setDisable(true);
            if(playing)
            {
                pause.setDisable(false);
                play.setDisable(true);
                update();
                // bindcurrenttimelabel();
            }
        }

       
    }

   
    public void pauseMedia(){
       mediaplayer.pause();
       pause1=true;
       playing=false; 
       if(pause1)
       {
           pause.setDisable(true);
           play.setDisable(false);
       }
        
    }
    public void nextMedia(){
        if(currentfile<file.size()-1)
        {
            playing=false;
            pauseMedia();
            currentfile++;
            media=new Media(file.get(currentfile).toURI().toString());
            mediaplayer=new MediaPlayer(media);
            play();
            update();  

            
        }
        else{
            playing=false;
            pauseMedia();
            currentfile=0;
            media=new Media(file.get(currentfile).toURI().toString());
            mediaplayer=new MediaPlayer(media);
            play();
            update();  


        }

        
    }
    public void previousMedia(){
        if(currentfile>0)
        {
           try {
                playing=false;
                pauseMedia();
                currentfile--;
                media=new Media(file.get(currentfile).toURI().toString());
                mediaplayer=new MediaPlayer(media);
                play();
                update(); 
           } catch (MediaException e) {
                playing=false;
                pauseMedia();
                currentfile=0;
                media=new Media(file.get(currentfile).toURI().toString());
                mediaplayer=new MediaPlayer(media);
                play();
                update();
           } 
        }
        else
        {
            playing=false;
            pauseMedia();
            currentfile=file.size()-1;
            media=new Media(file.get(currentfile).toURI().toString());
            mediaplayer=new MediaPlayer(media);
            play();
            update();  

        }

        
    }

    public void forwardMedia(){
        
        // System.out.println(lengthslider.getValue());;
        // Duration d1=(Duration.seconds(lengthslider.getValue())+10s);

        if(lengthslider.getValue()<(mediaplayer.getTotalDuration().toSeconds()-10))
        {
            lengthslider.setValue(lengthslider.getValue()+10);
        }
        
    }
    public void backwardMedia(){
        if(lengthslider.getValue()>(10))
        {
            lengthslider.setValue(lengthslider.getValue()-10);
        }
    }

    public void loopcurrentmedia(){
        // if(!isloopall)
        // {
            isloop=true;
            isloopall=false;
            loop.setDisable(true);

            
                loopall.setDisable(false);
            
    }

    public void doloopscurrent(){
        
        // if(playing&&!isloop)
        // {
            
            String endtime=getTime(mediaplayer.getTotalDuration());
            String currentTime=getTime(mediaplayer.getCurrentTime());
            if(currentTime.equals(endtime))
            {
                playing=false;
                play.setDisable(false);
                if(!playing){
                    mediaplayer.seek(Duration.seconds(0.0));
                    playing=true;
                    mediaplayer.play();
                    // update();
                    

                }   
            }
        // }
    }


    public void loopAllMedia(){
        
            isloop=false;
            isloopall=true;
            loopall.setDisable(true);
            loop.setDisable(false);

    }

   
      

    public void openmedia(ActionEvent event){
        
        FileChooser fileChooser=new FileChooser();
        FileChooser.ExtensionFilter filter=new ExtensionFilter("Select Mp3 Files", ("*.mp3"));
        fileChooser.getExtensionFilters().add(filter);
        List<File> multiple=new ArrayList<>();
        multiple=fileChooser.showOpenMultipleDialog(null);

        if(multiple!=null)
        {
            for (File file1 : multiple) {
                
                file.add(file1);
            }



        }

       if(!playing)
        {

            if(file.size()!=0)
            {
                
                // for (File file2 : file) {
                    
                    try {
                        
                        currentfile=0;
                        media=new Media(file.get(currentfile).toURI().toString());
                        mediaplayer=new MediaPlayer(media);

                        play();
                        update();

                    } catch (MediaException e) {
                        currentfile=0;
                        media=new Media(file.get(currentfile).toURI().toString());
                        mediaplayer=new MediaPlayer(media);
                        play();
                        update();

                    }
                    if(playing==true)
                    {
                        pause.setDisable(false);
                        play.setDisable(true);
                        forward.setDisable(false);
                        backward.setDisable(false);
                        stop.setDisable(false);
                        loop.setDisable(false);
                        loopall.setDisable(true);


                    }

                    if(file.size()>1)
                    {
                        this.next.setDisable(false);
                        this.previous.setDisable(false);
                        forward.setDisable(false);
                        loopall.setDisable(false);


                    }
            }
       }

        if(file.size()>1)
        {
            this.next.setDisable(false);
            this.previous.setDisable(false);
            forward.setDisable(false);
            loopall.setDisable(false);

        }
    

    }

    

    public void update()
    {
        // lengthslider.setMax(mediaplayer.getTotalDuration().toSeconds());
        lengthslider.setMin(0.0);
        bindcurrenttimelabel();
        volumeslider.setMin(0.0);
        volumeslider.setMax(1.0);
        // lengthslider.setMax(mediaplayer.getTotalDuration().toSeconds());
        // lengthslider.setMin(0.0);
        // mediaplayer.volumeProperty().bindBidirectional(volumeslider.valueProperty());
        mediaplayer.volumeProperty().bind(volumeslider.valueProperty());
      
        // lengthslider.setMax(value);
        // mediaplayer.setVolume(0.5);
        volumeslider.valueProperty().addListener(new InvalidationListener(){

            @Override
            public void invalidated(Observable arg0) {
                volume.setText(String.valueOf((int)(volumeslider.getValue()*100))+"%");

            }
            
        });



        // The valueChanging property indicates if the slider is in the process of being changed.
        // When true, indicates the current value of the slider is changing.
        lengthslider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasChanging, Boolean isChanging) {
                bindcurrenttimelabel();
                // Once the slider has stopped changing (the user lets go of the slider ball) then set the video to this time.
                if (!isChanging) {
                    // seek() seeks the player to a new time. Note that this has no effect while the player's  status is stopped or the duration is indefinite.
                    mediaplayer.seek(Duration.seconds(lengthslider.getValue()));
                }
            }

         
        });


        mediaplayer.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldDuration, Duration newDuration) {
                // Note that duraiton is originally in milliseconds.
                // newDuration is the time of the current video, oldDuration is the duration of the previous video.
                lengthslider.setMax(newDuration.toSeconds());
                totallength.setText(getTime(newDuration));

            }
        });


        // valueChangingProperty() - when true, indicates the current value of the slider is changing.
        // valueProperty() - the current value represented by the slider.

        // ValueProperty() is the current value represented by the slider. This value must always be between min and max.
        lengthslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                // bindcurrenttimelabel();
                // Get the current time of the video in seconds.
                double currentTime = mediaplayer.getCurrentTime().toSeconds();
                if (Math.abs(currentTime - newValue.doubleValue()) > 0.1) {
                    mediaplayer.seek(Duration.seconds(newValue.doubleValue()));
                }

                
            }
        });

        mediaplayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                // bindcurrenttimelabel();
                if (!lengthslider.isValueChanging()) {
                    lengthslider.setValue(newTime.toSeconds());

                }
                lengthslider.setValue(newTime.toSeconds());
                if(!isloop&&file.size()==1)
                {
                    String endtime=getTime(mediaplayer.getTotalDuration());

                    String currentTime=getTime(mediaplayer.getCurrentTime());
                    if(currentTime.equals(endtime))
                    {
                        mediaplayer.seek(Duration.seconds(0.0));
                        lengthslider.setValue((0.0));
                        mediaplayer.pause();
                    }
                }
               if(!isloop&&file.size()>1)
               {
                    String endtime=getTime(mediaplayer.getTotalDuration());
                    String currentTime=getTime(mediaplayer.getCurrentTime());
                    
                    if(currentTime.equals(endtime))
                    {
                        nextMedia();
                    }
               }
            }
        });


   


    }
    

    public void bindcurrenttimelabel(){
        currenttime.textProperty().bind(Bindings.createStringBinding(new Callable<String>(){
            
            @Override
            public String call() throws Exception {
                // totallength.setText(getTime(mediaplayer.getTotalDuration()));

                
                lengthslider.setValue(mediaplayer.getCurrentTime().toSeconds());
                if(isloop)
                {
                    doloopscurrent();
                }
               
                // play.setDisable(false);
                       
                return getTime(mediaplayer.getCurrentTime());
            }
            
        }, mediaplayer.currentTimeProperty()));
    }
  
   public String getTime(Duration time)
   {
        int hours = (int) time.toHours();
        int minutes = (int) time.toMinutes();
        int seconds = (int) time.toSeconds();

        // Fix the issue with the timer going to 61 and above for seconds, minutes, and hours.
        if (seconds > 59) seconds = seconds % 60;
        if (minutes > 59) minutes = minutes % 60;
        if (hours > 59) hours = hours % 60;

        // Don't show the hours unless the video has been playing for an hour or longer.
        if (hours > 0) return String.format("%d:%02d:%02d",
                hours,
                minutes,
                seconds);
        else return String.format("%02d:%02d",
                minutes,
                seconds);
   }
    
   public  void stopmedia(){

        if(playing){
            mediaplayer.stop();
            file.clear();
            currentfile=0;
            songname.setText(null);
            playing=false;
            play.setDisable(true);
            pause.setDisable(true);
            stop.setDisable(true);
            forward.setDisable(true);
            backward.setDisable(true);
            next.setDisable(true);
            previous.setDisable(true);
            loop.setDisable(true);
            loopall.setDisable(true);

        }
   }



}
