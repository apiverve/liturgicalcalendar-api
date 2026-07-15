"""
Liturgical Calendar API - Basic Usage Example

This example demonstrates the basic usage of the Liturgical Calendar API.
API Documentation: https://docs.apiverve.com/ref/liturgicalcalendar
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/liturgicalcalendar'

def call_liturgicalcalendar_api():
    """
    Make a GET request to the Liturgical Calendar API
    """
    try:
        # Query parameters
        params &#x3D; {&#x27;month&#x27;: 2}

        headers = {
            'x-api-key': API_KEY
        }

        response = requests.get(API_URL, headers=headers, params=params)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling Liturgical Calendar API...\n')

    result = call_liturgicalcalendar_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
