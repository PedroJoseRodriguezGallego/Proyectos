import os
from shutil import rmtree
import speech_recognition as sr
from pydub import AudioSegment
from pydub.silence import split_on_silence

r = sr.Recognizer()


def transform(path):
    fileName = path + ".mp3"
    fileName2 = path + ".wav"

    if os.path.exists(fileName):
        print("El archivo mp3 ya existe")
    else:
        command2mp3 = f"ffmpeg -i {path}.mp4 {path}.mp3"
        os.system(command2mp3)

    if os.path.exists(fileName2):
        print("El archivo wav ya existe")
    else:
        command2wav = f"ffmpeg -i {path}.mp3 {path}.wav"
        os.system(command2wav)


def transcribirAudio(path):
    audioCompleto = AudioSegment.from_wav(path)
    audiosCortos = split_on_silence(audioCompleto, min_silence_len=500, silence_thresh=audioCompleto.dBFS-14, keep_silence=500)
    carpetaAudios = "audio-audiosCortos"
    textoCompleto = ""

    if not os.path.isdir(carpetaAudios):
        os.mkdir(carpetaAudios)

    for i, audio_chunk in enumerate(audiosCortos, start=1):
        nombreAudioCorto = os.path.join(carpetaAudios, f"chunk{i}.wav")
        audio_chunk.export(nombreAudioCorto, format="wav")

        with sr.AudioFile(nombreAudioCorto) as source:
            audio_listened = r.record(source)

            try:
                text = r.recognize_google(audio_listened, language="es-ES")
            except sr.UnknownValueError as e:
                print("Error:", str(e))
            else:
                text = f"{text.capitalize()} "
                print(nombreAudioCorto, ":", text)
                textoCompleto = textoCompleto + text

    limpiarEspacio(path)

    return textoCompleto


def limpiarEspacio(path):
    rmtree("audio-audiosCortos")
    os.remove(path)
