var vid, playButton, timeSlider, currentTimeText, durationTimeText, muteButton, volumeSlider, fullscreenButton;
var currentVolume = 100;

function initializePlayer() 
{
	vid = document.getElementById("my_video");
	playButton = document.getElementById("playpausebutton");
	timeSlider = document.getElementById("timeSlider");
	currentTimeText = document.getElementById("currentTimeText");
	currentTimeText.innerHTML = "00" + ":" + "00";
	durationTimeText = document.getElementById("durationTimeText");
	durationTimeText.innerHTML = "02" + ":" + "58";
	muteButton = document.getElementById("muteButton");
	volumeSlider = document.getElementById("volumeSlider");
	fullscreenButton = document.getElementById("fullscreenButton");
	playButton.addEventListener("click", playPause, false);
	timeSlider.addEventListener("change", videoSeek, false);
	vid.addEventListener("timeupdate", sliderTimeUpdate, false);
	muteButton.addEventListener("click", videoMute, false);
	volumeSlider.addEventListener("change", setVolume, false);
	fullscreenButton.addEventListener("click", toggleFullscreen, false);
	vid.addEventListener("ended", replayImage, false);
	volumeSlider.addEventListener("change", muteImg, false);
}
window.onload = initializePlayer;

function playPause() 
{
	if (vid.paused) 
	{
		vid.play();
		playButton.style.background = "url(images/pause.png)";
	}

	else 
	{
		vid.pause();
		playButton.style.background = "url(images/play.png)";
	}
}


function videoSeek() 
{
	var vidCalc = vid.duration * (timeSlider.value / 100);
	vid.currentTime = vidCalc;
}


function sliderTimeUpdate() 
{
	var newTime = vid.currentTime * (100 / vid.duration);
	timeSlider.value = newTime;

	var currentMinutes = Math.floor(vid.currentTime / 60);
	var currentSeconds = Math.floor(vid.currentTime - currentMinutes * 60);

	var durationMinutes = Math.floor(vid.duration / 60);
	var durationSeconds = Math.round(vid.duration - durationMinutes * 60);

	if (currentSeconds < 10)
	{
		currentSeconds = "0" + currentSeconds;
	}

	if (durationSeconds < 10)
	{
		durationSeconds = "0" + durationSeconds;
	}

	if (currentMinutes < 10)
	{
		currentMinutes = "0" + currentMinutes;
	}

	if (durationMinutes < 10)
	{
		durationMinutes = "0" + durationMinutes;
	}

	currentTimeText.innerHTML = currentMinutes + ":" + currentSeconds;
	durationTimeText.innerHTML = durationMinutes + ":" + durationSeconds;
}


function replayImage()
{
	playButton.style.background = "url(images/replay.png)";
}


function videoMute()
{
	if (vid.muted) 
	{
        vid.muted = false;
        volumeSlider.value = currentVolume;
		vid.volume = volumeSlider.value / 100;
		muteButton.style.background = "url(images/unmute.png)";
	}

	else 
	{
		vid.muted = true;
		volumeSlider.value = 0;
		vid.volume = volumeSlider.value / 100;
		muteButton.style.background = "url(images/mute.png)";
	}
}


function setVolume()
{
    vid.volume = volumeSlider.value / 100;
    currentVolume = volumeSlider.value;
}


function muteImg()
{
	if(volumeSlider.value==0)
	{
		muteButton.style.background = "url(images/mute.png)";
	}
	
	else if(volumeSlider.value!==0)
	{
		muteButton.style.background = "url(images/unmute.png)";
	}
}


function toggleFullscreen()
{
	if (vid.requestFullscreen)
	{
		vid.requestFullscreen();
	} 
	
	else if (vid.webkitRequestFullScreen)
	{
		vid.webkitRequestFullScreen();
	} 
		
	else if (vid.mozRequestFullScreen)
	{
		vid.mozRequestFullScreen();
	}
}


function skipButton(value)
{
	var newTime = vid.currentTime + value;
	vid.currentTime = newTime;
}