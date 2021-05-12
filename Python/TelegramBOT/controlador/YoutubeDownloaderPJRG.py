from pytube import YouTube
from youtube_dl import YoutubeDL
import glob


def descargarVideo(URL):
    yt = YouTube(URL)
    ys = yt.streams.get_highest_resolution()
    ys.download()
    return obtenerRutaVideo()


def descargarAudio(URL):
    audio_downloader = YoutubeDL({'format': 'm4a'})
    audio_downloader.extract_info(URL)
    return obtenerRutaAudio()


def obtenerRutaAudio():
    for fichero in glob.iglob("*.m4a", recursive=True):
        return fichero


def obtenerRutaVideo():
    for fichero in glob.iglob("*.mp4", recursive=True):
        return fichero


if __name__ == "__main__":
    descargarVideo("https://www.youtube.com/watch?v=LDtABz-5Ka4")
