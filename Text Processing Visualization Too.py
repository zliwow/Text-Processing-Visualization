import tkinter as tk
from tkinter import simpledialog
import re
import nltk
import matplotlib.pyplot as plt
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

# Ensure required NLTK data is downloaded
nltk.download('punkt')
nltk.download('stopwords')

def clean_text(text):
    text = re.sub(r'http\S+', '', text)
    text = re.sub('[^A-Za-z ]+', '', text)
    text = text.lower()
    return text

def tokenize(text):
    return word_tokenize(text)

def remove_stop_words(words):
    stop_words = set(stopwords.words('english'))
    return [word for word in words if word not in stop_words]

def visualize_text_processing(text, cleaned_text, tokenized_words, filtered_words):
    fig, ax = plt.subplots(figsize=(15, 12))

    # Define positions for each level
    y_original = 0
    y_cleaned = -1
    y_tokenized = -2
    y_filtered = -3

    # Function to plot words
    def plot_words(words, y_level, parent_x_positions):
        n = len(words)
        x_positions = [i / (n + 1) for i in range(1, n + 1)]
        for i, word in enumerate(words):
            ax.text(x_positions[i], y_level, word, ha='center', va='center', fontsize=8)
            parent_x = parent_x_positions.get(word, 0.5)
            ax.plot([x_positions[i], parent_x], [y_level, y_level + 1], color='gray', linestyle='-', linewidth=1)
        return {word: x for word, x in zip(words, x_positions)}

    # Original and Cleaned Text
    ax.text(0.5, y_original, f"Original Text: {text}", ha='center', va='center', fontsize=9)
    ax.text(0.5, y_cleaned, f"Cleaned Text: {cleaned_text}", ha='center', va='center', fontsize=9)
    ax.plot([0.5, 0.5], [y_original, y_cleaned], color='gray', linestyle='-', linewidth=1)

    # Plot words for each stage
    token_positions = plot_words(tokenized_words, y_tokenized, {"Cleaned": 0.5})
    plot_words(filtered_words, y_filtered, token_positions)

    # Set plot parameters
    ax.axis('off')
    ax.set_xlim(0, 1)
    ax.set_ylim(y_filtered - 1, 1)
    plt.title("Text Processing Tree", fontsize=14)
    plt.show()

# Function to get user input with a pop-up box
def get_user_input():
    root = tk.Tk()
    root.withdraw()  # Hide the main window
    user_input = simpledialog.askstring("Text Input", "Enter your text (max 90 characters):", initialvalue="This is an example text with a URL https://example.com and some special characters! 1234")
    return user_input[:90] if user_input else None

# Get user input
user_text = get_user_input()
if user_text:
    cleaned_text = clean_text(user_text)
    tokenized_words = tokenize(cleaned_text)
    filtered_words = remove_stop_words(tokenized_words)

    # Visualize the text processing stages as a tree
    visualize_text_processing(user_text, cleaned_text, tokenized_words, filtered_words)
else:
    print("No text provided.")
